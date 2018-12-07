package ru.rvkhaustov.analysisdata.dao.impl;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.dto.Vacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;

import static ru.rvkhaustov.analysisdata.util.StaticParameters.DATE_TIME_FORMATTER_TOPIC;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcPassword;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUrl;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUser;


/**
 * Created by rvkha_000 .
 */
public class ParserDaoImpl implements ParserDao {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ParserDaoImpl.class);

    /**
     * SQL_EXCEPTION.
     */
    private static final String SQL_EXCEPTION = "Error, SQLException message: %s; SQLException SQL state: $s; SQLException SQL error code: $s;";
    /**
     * SQL_CREATE_TABLE_CONFIG.
     */
    private static final String SQL_CREATE_TABLE_CONFIG = "create table IF NOT EXISTS Config (dateParser character varying(50),fromDateTime character varying(50))";
    /**
     * SQL_CREATE_TABLE_VACANCY.
     */
    private static final String SQL_CREATE_TABLE_VACANCY = "create table IF NOT EXISTS Vacancy (title character varying(1000)"
            + ", body character varying(2000)"
            + ", ref character varying(400) UNIQUE ON CONFLICT IGNORE"
            + ",createDate character varying(30));";

    /**
     * SQL_INSERT_IN_TO_VACANCY.
     */
    private static final String SQL_INSERT_IN_TO_VACANCY = "INSERT INTO Vacancy (title, body, ref, createDate) VALUES (?, ?, ?, ?)";

    /**
     * SQL_INSERT_IN_TO_CONFIG.
     */
    private static final String SQL_INSERT_IN_TO_CONFIG = "INSERT INTO Config VALUES(CURRENT_TIMESTAMP, ?)";

    /**
     * SQL_LAST_DATE_CONFIG.
     */
    private static final String SQL_LAST_DATE_CONFIG = "select max(fromDateTime) as fromDateTime from Config";

    /**
     * fromDate.
     */
    private static final String FROM_DATE = "fromDateTime";

    /**
     * startParser.
     */
    private LocalDateTime startParser;


    /**
     * Create table.
     */
    public ParserDaoImpl() {
        executeSql(SQL_CREATE_TABLE_VACANCY, null, null);
        executeSql(SQL_CREATE_TABLE_CONFIG, null, null);
    }

    /**
     * @param vacancy vacancy
     */
    @Override
    public void insert(@NotNull Vacancy vacancy) {
        executeSql(SQL_INSERT_IN_TO_VACANCY,
                (filter) -> {
                    filter.setString(1, vacancy.getTitle());
                    filter.setString(2, vacancy.getBody());
                    filter.setString(3, vacancy.getRef());
                    filter.setString(4, vacancy.getCreateDate().format(DATE_TIME_FORMATTER_TOPIC));
                }, null);
    }

    @Override
    public void insertConfig() {
        executeSql(SQL_INSERT_IN_TO_CONFIG, (filter) -> {
            filter.setString(1, startParser.format(DATE_TIME_FORMATTER_TOPIC));
        }, null);
    }

    /**
     * @return item
     */
    @Override
    public LocalDateTime lastDateTime() {

        String[] lastLoadDateTimeString = new String[1];
        startParser = LocalDateTime.now();

        executeSql(SQL_LAST_DATE_CONFIG, null, (resultSet) -> {
            lastLoadDateTimeString[0] = resultSet.getString(FROM_DATE);
        });

        LocalDateTime beginNowYear = LocalDateTime.of(startParser.getYear(), Month.JANUARY, 1, 0, 0, 0);

        if (lastLoadDateTimeString[0] == null) {
            return beginNowYear;
        }

        LocalDateTime lastLoadDateTime = LocalDateTime.parse(lastLoadDateTimeString[0], DATE_TIME_FORMATTER_TOPIC);
        return lastLoadDateTime.compareTo(beginNowYear) > 0 ? lastLoadDateTime : beginNowYear;
    }


    /**
     * @param sql                     sql
     * @param filterPreparedStatement data input
     * @param handler                 data output
     */
    private void executeSql(String sql,
                            FilterPreparedStatement filterPreparedStatement,
                            ResultSetHandler handler) {
        try (
                Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
                PreparedStatement statement = connection.prepareStatement(sql)) {
            if (filterPreparedStatement != null) {
                filterPreparedStatement.filter(statement);
            }
            if (handler != null) {
                try (ResultSet rs = statement.executeQuery()) {
                    while (rs.next()) {
                        handler.handle(rs);
                    }
                }
            } else {
                statement.execute();
            }
        } catch (SQLException e) {
            LOGGER.error(String.format(SQL_EXCEPTION, e.getMessage(), e.getSQLState(), e.getErrorCode()));
        }
    }

    /**
     * This method will be executed by the lambda expression.
     */
    @FunctionalInterface
    interface ResultSetHandler {

        /**
         * This method will be executed by the lambda expression.
         *
         * @param resultSet resultSet
         * @throws SQLException SQLException
         */
        void handle(ResultSet resultSet) throws SQLException;
    }

    /**
     * This method will be executed by the lambda expression.
     */
    @FunctionalInterface
    interface FilterPreparedStatement {

        /**
         * This method will be executed by the lambda expression.
         *
         * @param statement statement
         * @throws SQLException SQLException
         */
        void filter(PreparedStatement statement) throws SQLException;
    }

}

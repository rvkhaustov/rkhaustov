package ru.rvkhaustov.analysisdata.dao.impl;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.pojo.Vacancy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcPassword;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUrl;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUser;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlCreateTableConfig;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlCreateTableVacancy;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlInsertInToConfig;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlInsertInToVacancy;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlLastDayConfig;

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
     * fromDate.
     */
    private static final String FROM_DATE = "fromDate";

    /**
     * startParser.
     */
    private Calendar startParser;

    /**
     * @param vacancy vacancy
     */
    @Override
    public void insert(@NotNull Vacancy vacancy) {
        executeSql(sqlInsertInToVacancy,
                (filter) -> {
                    filter.setString(1, vacancy.getTitle());
                    filter.setString(2, vacancy.getBody());
                    filter.setString(3, vacancy.getRef());
                    filter.setLong(4, vacancy.getCreateDate().getTimeInMillis());
                }, null);
    }

    @Override
    public void insertConfig() {
        executeSql(sqlInsertInToConfig, (filter) -> {
            filter.setLong(1, startParser.getTimeInMillis());
        }, null);
    }

    /**
     * @return item
     */
    @Override
    public Long lastDate() {
        Long[] lastDay = new Long[1];

        startParser = Calendar.getInstance();
        startParser.add(Calendar.DAY_OF_MONTH, -1);
        executeSql(sqlCreateTableVacancy, null, null);
        executeSql(sqlCreateTableConfig, null, null);
        executeSql(sqlLastDayConfig, null, (resultSet) -> {
            lastDay[0] = resultSet.getLong(FROM_DATE);
        });
        Calendar nowYear = Calendar.getInstance();
        nowYear.set(nowYear.get(Calendar.YEAR), 0, 1, 0, 0, 0);

        if (lastDay[0] == null || lastDay[0] < nowYear.getTimeInMillis()) {
            return nowYear.getTimeInMillis();
        }
        return lastDay[0];
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
            catchSQLException(e);
        }
    }

    /**
     * @param e SQLException
     */
    private void catchSQLException(SQLException e) {
        String messageError = String.format(SQL_EXCEPTION, e.getMessage(), e.getSQLState(), e.getErrorCode());
        LOGGER.error(messageError);
        throw new RuntimeException(messageError);
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

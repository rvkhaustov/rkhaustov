package ru.rvkhaustov.app.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.app.dao.DaoService;
import ru.rvkhaustov.app.pojo.Field;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ru.rvkhaustov.app.utils.StaticParameter.CLASS_NOT_FOUND_EXCEPTION;
import static ru.rvkhaustov.app.utils.StaticParameter.JDBC_DRIVER;
import static ru.rvkhaustov.app.utils.StaticParameter.JDBC_URL;
import static ru.rvkhaustov.app.utils.StaticParameter.SQL_CREATE_TEST;
import static ru.rvkhaustov.app.utils.StaticParameter.SQL_DROP_TABLE_TEST;
import static ru.rvkhaustov.app.utils.StaticParameter.SQL_EXCEPTION;
import static ru.rvkhaustov.app.utils.StaticParameter.SQL_INSERT_TEST;
import static ru.rvkhaustov.app.utils.StaticParameter.SQL_SELECT_TEST;


/**
 * Created by rvkha_000 on 22.04.2018.
 */
public class DaoServiceImpl implements DaoService {
    /**
     * url.
     */
    private String url;

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DaoServiceImpl.class);


    /**
     * @param database database
     */
    public DaoServiceImpl(String database) {
        this.url = JDBC_URL + ":" + database;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (Exception ex) {
            String messageError = String.format(CLASS_NOT_FOUND_EXCEPTION, ex.getMessage());
            LOGGER.error(messageError);
            System.out.println(messageError);
            ex.printStackTrace();
            return;
        }
        createTable();
    }

    /**
     * createTable.
     */
    private void createTable() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(SQL_DROP_TABLE_TEST);
            statement.executeUpdate(SQL_CREATE_TEST);
        } catch (SQLException e) {
            catchSQLException(e);
        }
    }

    /**
     * @return Connection
     * @throws SQLException SQLException
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url);
    }

    /**
     * @param e SQLException
     */
    private void catchSQLException(SQLException e) {
        String messageError = String.format(SQL_EXCEPTION, e.getMessage(), e.getSQLState(), e.getErrorCode());
        LOGGER.error(messageError);
        System.out.println(messageError);
        e.printStackTrace();
    }

    /**
     * @param from from field
     * @param to   to field
     */
    @Override
    public void insert(long from, long to) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_TEST)) {
            connection.setAutoCommit(false);
            for (long l = from; l < to; l++) {
                preparedStatement.setLong(1, l);
                preparedStatement.execute();
            }
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            catchSQLException(e);
        }
    }

    /**
     * @param from from field
     * @param to   to field
     * @return select fields
     */
    @Override
    public List<Field> select(long from, final long to) {
        List<Field> fields = new ArrayList<>((int) to);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_TEST);
             ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                Field field = new Field();
                field.setField(rs.getInt(1));
                fields.add(field);
            }
        } catch (SQLException e) {
            catchSQLException(e);
        }
        return fields;
    }
}

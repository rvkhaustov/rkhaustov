package ru.rkhaustov.tracker.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rkhaustov.tracker.Item;
import ru.rkhaustov.tracker.dao.TrackerDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by rvkha_000 on 13.04.2018.
 */
public class TrackerDaoPlainJdbcImpl implements TrackerDao {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerDaoPlainJdbcImpl.class);
    /**
     * CONFIG_PROPERTIES.
     */
    public static final String CONFIG_PROPERTIES = "config.properties";

    /**
     * CONFIG_PROPERTIES_ABS_PATH.
     */
    public static final String CONFIG_PROPERTIES_ABS_PATH = String.format("%s/Config/",
            new File("").getAbsolutePath());
    /**
     * CONFIG_PROPERTIES_PATH_ERROR.
     */
    public static final String CONFIG_PROPERTIES_PATH_ERROR = "Error: %s, \r\n no file config.properties." + " Example command: java -Dconfig.properties='/path/to/uploads/config.properties' -jar tracker.jar.";

    /**
     * JDBC_DRIVER.
     */
    public static final String JDBC_DRIVER = "jdbc.driver";
    /**
     * JDBC_URL.
     */
    private static final String JDBC_URL = "jdbc.url";
    /**
     * jdbcUrlValue.
     */
    private static String jdbcUrlValue;
    /**
     * JDBC_USER.
     */
    private static final String JDBC_USER = "jdbc.user";
    /**
     * jdbcUserValue.
     */
    private static String jdbcUserValue;
    /**
     * JDBC_PASSWORD.
     */
    private static final String JDBC_PASSWORD = "jdbc.password";
    /**
     * jdbcPasswordValue.
     */
    private static String jdbcPasswordValue;

    /**
     * CLASS_NOT_FOUND_EXCEPTION.
     */
    private static final String CLASS_NOT_FOUND_EXCEPTION = "Error: ClassNotFoundException %s";

    /**
     * SQL_CREATE_TABLE_ITEM.
     */
    private static final String SQL_CREATE_TABLE_ITEM = "sql.createTableItem";
    /**
     * SQL_INSERT_INTO_ITEM.
     */
    private static final String SQL_INSERT_INTO_ITEM = "sql.insertIntoItem";
    /**
     * SQL_SELECT_ALL_ITEM.
     */
    private static final String SQL_SELECT_ALL_ITEM = "sql.selectAllItem";
    /**
     * SQL_UPDATE_BY_ID_ITEM.
     */
    private static final String SQL_UPDATE_BY_ID_ITEM = "sql.updateByIdItem";
    /**
     * SQL_DELETE_BY_ID_ITEM.
     */
    private static final String SQL_DELETE_BY_ID_ITEM = "sql.deleteByIdItem";
    /**
     * SQL_FIND_ITEM_BY_NAME.
     */
    private static final String SQL_FIND_ITEM_BY_NAME = "sql.findItemByName";
    /**
     * SQL_FIND_ITEM_BY_ID.
     */
    private static final String SQL_FIND_ITEM_BY_ID = "sql.findItemById";
    /**
     * SQL_EXCEPTION.
     */
    private static final String SQL_EXCEPTION = "Error, SQLException message: %s; SQLException SQL state: $s; SQLException SQL error code: $s;";


    /**
     * ID_TABLE.
     */
    private static final String ID_TABLE = "idTable";
    /**
     * ITEM_ID.
     */
    private static final String ITEM_ID = "id";
    /**
     * ITEM_NAME.
     */
    private static final String ITEM_NAME = "name";
    /**
     * ITEM_DESCRIPTION.
     */
    private static final String ITEM_DESCRIPTION = "description";
    /**
     * ITEM_COMMENTS.
     */
    private static final String ITEM_COMMENTS = "comments";

    /**
     * ITEM_CREATED.
     */
    private static final String ITEM_CREATED = "created";

    /**
     * PROPERTIES_CONFIG.
     */
    private static Properties propertiesConfig;

    /**
     * initStatus.
     */
    private boolean initStatus;

    /**
     * TrackerDaoPlainJdbcImpl.
     */
    public TrackerDaoPlainJdbcImpl() {
//    static {
        propertiesConfig = new Properties();
        String fileConfigJdbc = System.getProperty(CONFIG_PROPERTIES) == null
                ? CONFIG_PROPERTIES_ABS_PATH + CONFIG_PROPERTIES : System.getProperty(CONFIG_PROPERTIES);
        try (FileInputStream fis = new FileInputStream(fileConfigJdbc)) {
            propertiesConfig.load(fis);
            Class.forName(propertiesConfig.getProperty(JDBC_DRIVER));
        } catch (FileNotFoundException e) {
            String messageError = String.format(CONFIG_PROPERTIES_PATH_ERROR, e.getMessage());
            LOGGER.error(messageError);
            System.out.println(messageError);
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException ex) {
            String messageError = String.format(CLASS_NOT_FOUND_EXCEPTION, ex.getMessage());
            LOGGER.error(messageError);
            System.out.println(messageError);
            ex.printStackTrace();
            return;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
        jdbcUrlValue = propertiesConfig.getProperty(JDBC_URL);
        jdbcUserValue = propertiesConfig.getProperty(JDBC_USER);
        jdbcPasswordValue = propertiesConfig.getProperty(JDBC_PASSWORD);
        executeSql(propertiesConfig.getProperty(SQL_CREATE_TABLE_ITEM), null, null);
        initStatus = true;
    }

    /**
     * @param e SQLException
     */
    private void catchSQLException(SQLException e) {
        initStatus = false;
        String messageError = String.format(SQL_EXCEPTION, e.getMessage(), e.getSQLState(), e.getErrorCode());
        LOGGER.error(messageError);
        System.out.println(messageError);
        e.printStackTrace();
    }

    /**
     * @return true else initialization success, else false.
     */
    @Override
    public boolean initStatus() {
        return initStatus;
    }

    /**
     * Method add - add item.
     *
     * @param item add item
     * @return item
     */
    @Override
    public Long add(Item item) {
        List<Long> id = new ArrayList<>(1);
        executeSql(propertiesConfig.getProperty(SQL_INSERT_INTO_ITEM),
                (filter) -> {
                    filter.setString(1, item.getId() == null ? generatID() : item.getId());
                    filter.setString(2, item.getName());
                    filter.setString(3, item.getDescription());
                    filter.setString(4, item.getComments());
                    filter.setLong(5, item.getCreated());
                }, (resultSet) -> {
                    id.add(resultSet.getLong(ID_TABLE));
                    return;
                });
        return id.isEmpty() ? null : id.get(0);
    }

    /**
     * @return collection all items.
     */
    @Override
    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        executeSql(propertiesConfig.getProperty(SQL_SELECT_ALL_ITEM), null, (resultSet) -> {
            items.add(fillItemFromResultSet(resultSet));
        });
        return items;
    }

    /**
     * @param resultSet resultSet
     * @return item.
     * @throws SQLException SQLException
     */
    private Item fillItemFromResultSet(ResultSet resultSet) throws SQLException {
        return new Item(resultSet.getString(ITEM_ID),
                resultSet.getString(ITEM_NAME),
                resultSet.getString(ITEM_DESCRIPTION),
                resultSet.getString(ITEM_COMMENTS),
                resultSet.getLong(ITEM_CREATED));
    }

    /**
     * @param item update
     */
    @Override
    public void update(Item item) {
        executeSql(propertiesConfig.getProperty(SQL_UPDATE_BY_ID_ITEM), (filter) -> {
            filter.setString(1, item.getName());
            filter.setString(2, item.getDescription());
            filter.setString(3, item.getComments());
            filter.setLong(4, item.getCreated());
            filter.setString(5, item.getId());
        }, null);
    }

    /**
     * @param item delete
     */
    @Override
    public void delete(Item item) {
        executeSql(propertiesConfig.getProperty(SQL_DELETE_BY_ID_ITEM), (filter) -> {
            filter.setString(1, item.getId());
        }, null);
    }

    /**
     * findByName.
     *
     * @param key search name
     * @return List item
     */
    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        executeSql(propertiesConfig.getProperty(SQL_FIND_ITEM_BY_NAME), (filter) -> {
            filter.setString(1, key);
        }, (resultSet) -> {
            items.add(fillItemFromResultSet(resultSet));
        });
        return items;
    }

    /**
     * @param id search id
     * @return item
     */
    @Override
    public Item findById(String id) {
        List<Item> items = new ArrayList<>(1);
        executeSql(propertiesConfig.getProperty(SQL_FIND_ITEM_BY_ID), (filter) -> {
            filter.setString(1, id);
        }, (resultSet) -> {
            items.add(fillItemFromResultSet(resultSet));
        });
        if (items.size() == 1) {
            return items.get(0);
        } else if (items.size() > 1) {
            throw new RuntimeException("Return > 2");
        }
        return new Item();
    }

    /**
     * @param sql                     sql
     * @param filterPreparedStatement data input
     * @param handler                 data output
     */
    private void executeSql(String sql,
                            FilterPreparedStatement filterPreparedStatement,
                            ResultSetHandler handler) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrlValue, jdbcUserValue, jdbcPasswordValue);
            PreparedStatement statement = connection.prepareStatement(sql);
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
        } finally {
            if (connection == null) {
                return;
            }
            try {
                connection.close();
            } catch (SQLException e) {
                catchSQLException(e);
            }
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

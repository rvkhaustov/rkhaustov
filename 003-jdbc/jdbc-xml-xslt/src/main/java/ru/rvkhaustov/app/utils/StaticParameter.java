package ru.rvkhaustov.app.utils;

import java.io.File;

/**
 * Created by rvkha_000 on 22.04.2018.
 */
public abstract class StaticParameter {
    /**
     * SQL_EXCEPTION.
     */
    public static final String SQL_EXCEPTION = "Error, SQLException message: %s; SQLException SQL state: $s; SQLException SQL error code: $s;";

    /**
     * JDBC_URL.
     */
    public static final String JDBC_URL = "jdbc:sqlite";
    /**
     * SQL_INSERT_TEST.
     */
    public static final String SQL_INSERT_TEST = "insert into TEST values(?)";
    /**
     * SQL_CREATE_TEST.
     */
    public static final String SQL_CREATE_TEST = "create table IF NOT EXISTS TEST ( field numeric(20, 0))";
    /**
     * SQL_DROP_TABLE_TEST.
     */
    public static final String SQL_DROP_TABLE_TEST = "drop table IF EXISTS TEST";
    /**
     * SQL_SELECT_TEST.
     */
    public static final String SQL_SELECT_TEST = "select field from TEST";

    /**
     * JDBC_DRIVER.
     */
    public static final String JDBC_DRIVER = "org.sqlite.JDBC";

    /**
     * PARAMETRS_ARGS_ERROR.
     */
    public static final String PARAMETRS_ARGS_ERROR = "No correct parameters. First parameter name database (JDBC Driver:SQLite)."
            + " Second parameter count records. Example command: startJXX opt/sqlite/test.sqlite 1000000";
    /**
     * CLASS_NOT_FOUND_EXCEPTION.
     */
    public static final String CLASS_NOT_FOUND_EXCEPTION = "Error: ClassNotFoundException %s";

    /**
     * DAO_SERVICE_INSERT.
     */
    public static final String DAO_SERVICE_INSERT = "DaoService insert Time millis: %s : sec: %s";
    /**
     * DAO_SERVICE_SELECT.
     */
    public static final String DAO_SERVICE_SELECT = "DaoService select Time millis: %s : sec: %s";
    /**
     * XML_SERVICE_XML_FROM_DAO.
     */
    public static final String XML_SERVICE_XML_FROM_DAO = "CreateXmlFromDaoXmlService Time millis: %s : sec: %s";
    /**
     * TRANSFORM_FROM_XML_XLST.
     */
    public static final String TRANSFORM_FROM_XML_XLST = "TransformFromXmlToXlstXmlService Time millis: %s : sec: %s";
    /**
     * ARIFMETIC_SUM.
     */
    public static final String ARIFMETIC_SUM = "FildsFromSecondXml and Arifmetic Sum Time millis: %s : sec: %s";
    /**
     * ALL_TIME.
     */
    public static final String ALL_TIME = "All Time millis: %s : sec: %s";

    /**
     * ABSOLUTE_PATCH.
     */
    public static final String ABSOLUTE_PATCH = new File("").getAbsolutePath();
    /**
     * XML_FIRST_FILE.
     */
    public static final String XML_FIRST_FILE = ABSOLUTE_PATCH + "/1.xml";
    /**
     * XML_FIRST_FILE_ERROR.
     */
    public static final String XML_FIRST_FILE_ERROR = "ERROR:  Can not create " + XML_FIRST_FILE + " file, %s";
    /**
     * XML_SECOND_FILE.
     */
    public static final String XML_SECOND_FILE = ABSOLUTE_PATCH + "/2.xml";
    /**
     * XSLT_FILE.
     */
    public static final String XSLT_FILE = ABSOLUTE_PATCH + File.separator + "transform.xslt";
    /**
     * XSLT_FILE_TEXT.
     */
    public static final String XSLT_FILE_TEXT = " <xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:template match=\"entries\"><entries><xsl:apply-templates/></entries></xsl:template><xsl:template match=\"entry\"><entry field=\"{field}\"/></xsl:template></xsl:stylesheet>";

}

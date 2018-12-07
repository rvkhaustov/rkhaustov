package ru.rvkhaustov.analysisdata.util;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.Locale;

/**
 * Created by rvkha_000 on 16.05.2018.
 */

public abstract class StaticParameters {
    /**
     * User agent.
     */
    public static final String USER_AGENT = "Chrome";
    /**
     * Pattern.
     */
    public static final Pattern PATTERN = Pattern.compile("\\b[Jj]ava\\b");
    /**
     * START_PARSERS.
     */
    public static final String START_PARSERS = "Start the parser from {}";
    /**
     * STRING_SERCH.
     */
    public static final String STRING_SERCH = "http://www.sql.ru/forum/job/%s";
    /**
     * postslisttopic.
     */
    public static final String CLASS_POSTS_LIST_TOPIC = "postslisttopic";
    /**
     * CLASS_ALT_COL.
     */
    public static final String CLASS_ALT_COL = "altCol";
    /**
     * JDBC_URL.
     */
    public static String jdbcUrl = "jdbc.url";

    /**
     * JDBC_USER.
     */
    public static String jdbcUser = "jdbc.user";

    /**
     * JDBC_PASSWORD.
     */
    public static String jdbcPassword = "jdbc.password";
    /**
     * quartz-scheduler.cronExpression.
     */
    public static String qsCronExpression = "quartz-scheduler.cronExpression";
    /**
     * CONFIG_PROPERTIES_PATH_ERROR.
     */
    public static final String APP_PROPERTIES_ERROR = "Error: parameter %s must in properties file.";

    /**
     * DATE_TIME_FORMATTER_TOPIC.
     */
    public static final DateTimeFormatter DATE_TIME_FORMATTER_TOPIC =  DateTimeFormatter.ofPattern("dd MMM yy HH:mm").withLocale(Locale.getDefault()); //.forLanguageTag("ru","RU"));
}

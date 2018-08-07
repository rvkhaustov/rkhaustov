package ru.rvkhaustov.analysisdata;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.analysisdata.dao.ParserDao;
import ru.rvkhaustov.analysisdata.dao.impl.ParserDaoImpl;
import ru.rvkhaustov.analysisdata.job.ParserJob;
import ru.rvkhaustov.analysisdata.parser.Parsers;
import ru.rvkhaustov.analysisdata.parser.impl.ParsersImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.APP_PROPERTIES_ERROR;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcPassword;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUrl;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.jdbcUser;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.qsCronExpression;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlCreateTableConfig;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlCreateTableVacancy;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlInsertInToConfig;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlInsertInToVacancy;
import static ru.rvkhaustov.analysisdata.util.StaticParameters.sqlLastDayConfig;

/**
 * Created by rvkha_000 on 16.07.2018.
 */
public class SqlRuParser {
    /**
     * Logger.
     */
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SqlRuParser.class);

    /**
     * CONFIG_PROPERTIES_PATH_ERROR.
     */
    public static final String CONFIG_PROPERTIES_PATH_ERROR = "Error no file app.properties. Example command: java -jar SqlRuParser app.properties";

    /**
     * CONFIG_PROPERTIES_ABS_PATH.
     */
    public static final String CONFIG_PROPERTIES_ABS_PATH = new File("").getAbsolutePath();

    /**
     * @param args path to file
     */
     public static void main(String[] args) {
        if (args.length == 0) {
            LOGGER.error(CONFIG_PROPERTIES_PATH_ERROR);
            return;
        }
        Properties propertiesConfig = new Properties();
        String appProperties = args[0];
        String fileappProperties = CONFIG_PROPERTIES_ABS_PATH + appProperties;
        final File file = new File(fileappProperties);
        fileappProperties = file.exists() ? fileappProperties : appProperties;
        try (FileInputStream fis = new FileInputStream(fileappProperties)) {

            propertiesConfig.load(fis);
            checkProperties(propertiesConfig);

            ParserDao parserDao = new ParserDaoImpl();
            Parsers parsers = new ParsersImpl();

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("parserDao", parserDao);
            jobDataMap.put("parsers", parsers);

            JobDetail job = newJob(ParserJob.class)
                    .withIdentity("SqlRu", "Parsers")
                    .usingJobData(jobDataMap)
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("myTrigger", "Parsers")
                    .withSchedule(cronSchedule(qsCronExpression))
                    .build();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();

        } catch (FileNotFoundException e) {
            String messageError = String.format(CONFIG_PROPERTIES_PATH_ERROR, e.getMessage());
            LOGGER.error(messageError);
            System.out.println(messageError);
            e.printStackTrace();
            return;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;

        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        }
    }


    /**
     * @param propertiesConfig properties config.
     */
    private static void checkProperties(Properties propertiesConfig) {
        List<Object> properties = new ArrayList<>();
        properties.add(jdbcUrl);
        properties.add(jdbcUser);
        properties.add(jdbcPassword);

        properties.add(sqlCreateTableVacancy);
        properties.add(sqlInsertInToVacancy);

        properties.add(sqlCreateTableVacancy);
        properties.add(sqlCreateTableConfig);
        properties.add(sqlInsertInToConfig);
        properties.add(sqlLastDayConfig);

        properties.add(qsCronExpression);

        properties.forEach(p -> {
            if (!propertiesConfig.containsKey(p)) {
                String errorMessage = String.format(APP_PROPERTIES_ERROR, p);
                LOGGER.error(errorMessage);
                throw new RuntimeException(errorMessage);
            }
        });

        jdbcUrl = propertiesConfig.getProperty(jdbcUrl);
        jdbcUser = propertiesConfig.getProperty(jdbcUser);
        jdbcPassword = propertiesConfig.getProperty(jdbcPassword);

        sqlCreateTableVacancy = propertiesConfig.getProperty(sqlCreateTableVacancy);
        sqlInsertInToVacancy = propertiesConfig.getProperty(sqlInsertInToVacancy);

        sqlCreateTableConfig = propertiesConfig.getProperty(sqlCreateTableConfig);
        sqlLastDayConfig = propertiesConfig.getProperty(sqlLastDayConfig);
        sqlInsertInToConfig = propertiesConfig.getProperty(sqlInsertInToConfig);

        qsCronExpression = propertiesConfig.getProperty(qsCronExpression);
    }
}

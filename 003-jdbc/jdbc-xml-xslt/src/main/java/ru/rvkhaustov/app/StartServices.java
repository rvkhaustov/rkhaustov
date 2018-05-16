package ru.rvkhaustov.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.app.services.ServicesRun;
import ru.rvkhaustov.app.services.impl.ServicesRunImpl;
//import org.apache.log4j.Logger;

import static ru.rvkhaustov.app.utils.StaticParameter.PARAMETRS_ARGS_ERROR;

/**
 * Created by rvkha_000 on 23.04.2018.
 */
public class StartServices {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartServices.class);

    /**
     * @param args args.
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2 || args[0] == null || args[1] == null || Long.valueOf(args[1]) < 1) {
                LOGGER.error(PARAMETRS_ARGS_ERROR);
                System.out.println(PARAMETRS_ARGS_ERROR);
                return;
            }
        } catch (Exception ex) {
            String message = PARAMETRS_ARGS_ERROR + " Error:" + ex;
            System.out.println(message);
            LOGGER.error(message);
            ex.printStackTrace();
            return;
        }
        ServicesRun servicesRun = new ServicesRunImpl();
        servicesRun.setDatabase(args[0]);
        servicesRun.setCount(Long.valueOf(args[1]));
        servicesRun.execute();
    }

}

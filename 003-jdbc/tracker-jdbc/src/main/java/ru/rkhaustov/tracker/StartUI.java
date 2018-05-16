package ru.rkhaustov.tracker;


import ru.rkhaustov.tracker.dao.TrackerDao;
import ru.rkhaustov.tracker.dao.impl.TrackerDaoPlainJdbcImpl;

import java.util.List;

/**
 * Class StartUI entry point in the program.
 *
 * @version 1.0
 * @since 04.2017
 */


public class StartUI {
    /**
     * @param input keybord
     */
    private Input input;

    /**
     * @param tracker class TrackerList
     */
    private TrackerDao tracker;

    /**
     * Error, initialization TrackerDao, see logs.
     */
    private static final String ERROR_INITIALIZATION = "Error, initialization TrackerDao, see logs.";

    /**
     * Constructor class StartUI initialization i/o and tracker.
     *
     * @param input   initialization i/o
     * @param tracker class tracker
     */

    public StartUI(Input input, TrackerDao tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * init - init main.
     */
    public void init() {

        MenuTracker menuTracker = new MenuTracker(this.input, tracker);
        menuTracker.fillAction();
        List<Integer> ranges = menuTracker.fillRange();
        do {
            menuTracker.show();
            menuTracker.select(input.ask("Select: ", ranges));
        } while (!"y".equals(this.input.ask("Exit? y")));
    }

    /**
     * Method main for start application.
     *
     * @param args params
     */
    public static void main(String[] args) {
        ConsoleInput input = new ValidateInput();
//        TrackerDao tracker = new TrackerDaoListImpl();
        TrackerDao tracker = new TrackerDaoPlainJdbcImpl();
        if (tracker.initStatus()) {
            new StartUI(input, tracker).init();
        } else {
            System.out.println(ERROR_INITIALIZATION);
        }
    }
}
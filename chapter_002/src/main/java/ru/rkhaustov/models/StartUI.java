package ru.rkhaustov.models;


import java.util.List;

/**
 * Class StartUI entry point in the program.
 * @version 1.0
 * @since 04.2017
 */


public class StartUI {
    /**
     * @param input keybord
     */
    private Input input;

    /**
     * @param tracker class Tracker
     */
    private Tracker tracker;

    /**
     * Constructor class StartUI initialization i/o and tracker.
     * @param input initialization i/o
     * @param tracker class tracker
     */

    public StartUI(Input input, Tracker tracker) {
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
     * @param args params
     */
    public static void main(String[] args) {
        ConsoleInput input = new ValidateInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}
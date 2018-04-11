package ru.rkhaustov.tracker;

/**
 * StubInput - substitution of user input.
 * @author rvkhaustov
 * @version 1.0
 * @since 04.2017
 */
public interface UserAction {
    /**
     *
     * @return number item menu
     */
    int key();

    /**
     * execute action item menu.
     * @param input - select item.
     * @param tracker reference on tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     *
     * @return string menu.
     */
    String info();
}

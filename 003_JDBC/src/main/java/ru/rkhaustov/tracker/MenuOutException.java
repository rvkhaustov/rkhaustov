package ru.rkhaustov.tracker;

/**
 * Created by rvkha_000 on 25.04.2017.
 * @version 1.0
 * @since 05.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     *
     * @param msg - text message.
     */
    public MenuOutException(String msg) {
        super(msg);
    }

}

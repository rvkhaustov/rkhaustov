package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class OccupiedWayException extends RuntimeException {
    /**
     *
     * @param msg - text message.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }

}

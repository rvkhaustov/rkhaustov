package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     *
     * @param msg - text message.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }

}

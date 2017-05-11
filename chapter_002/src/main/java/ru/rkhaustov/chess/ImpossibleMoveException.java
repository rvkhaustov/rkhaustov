package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class ImpossibleMoveException extends Exception {
    /**
     * @param exc text.
     */
    public ImpossibleMoveException(String exc) {
        super(exc);
    }
}

package ru.rkhaustov.models;

/**
 * Created by rvkha_000 on 25.04.2017.
 * @version 1.0
 * @since 04.2017
 */
public interface Input {
    /**
     *
     * @param question interface.
     * @return Response of the user
     */
    String ask(String question);
}
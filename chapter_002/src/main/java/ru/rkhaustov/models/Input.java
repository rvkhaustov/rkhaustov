package ru.rkhaustov.models;

import java.util.List;

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

    /**
     *
     * @param question - text question.
     * @param range - Possible menu items.
     * @return - select menu items.
     */
    int ask(String question, List<Integer> range);
}

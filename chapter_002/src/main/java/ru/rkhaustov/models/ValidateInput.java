package ru.rkhaustov.models;

import java.util.List;

/**
 * Created by rvkha_000 on 25.04.2017.
 * @version 1.0
 * @since 05.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     *
     * @param question - text question.
     * @param range - Possible menu items.
     * @return - select menu items.
     */
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;

            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate again.");
            } catch (MenuOutException moe) {
//                moe.printStackTrace();
                System.out.println("Please select key from menus.");
            }
        } while (invalid);
        return value;

    }
}

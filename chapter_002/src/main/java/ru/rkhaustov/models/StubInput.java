package ru.rkhaustov.models;

import java.util.List;

/**
 * StubInput - substitution of user input.
 * @author rvkhaustov
 * @version 1.0
 * @since 04.2017
 */
public class StubInput implements Input {
    /**
     * @param answers - answers
     */
    private String[] answers;
    /**
     * @param position - count answers
     */
    private int position = 0;

    /**
     * StubInput setter.
     * @param answers - answers
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, List<Integer> range) throws MenuOutException {
        int key = Integer.valueOf(answers[position++]);
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("out of menu range");
        }
    }
}

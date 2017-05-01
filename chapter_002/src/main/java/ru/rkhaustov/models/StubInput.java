package ru.rkhaustov.models;

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
    public int ask(String question, int[] range) {
//        throw new UnsupportedOperationException("Unsupported operation");
        return Integer.valueOf(answers[position++]);
    }
}

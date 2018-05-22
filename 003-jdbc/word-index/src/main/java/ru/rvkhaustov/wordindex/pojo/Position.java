package ru.rvkhaustov.wordindex.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rvkha_000 on 16.05.2018.
 */
public class Position {
    /**
     * Line words.
     */
    private Set<Integer> line = new HashSet<>(1);

    /**
     * Column words.
     */
    private Set<Integer> column = new HashSet<>(1);

    /**
     * Empty constructor.
     */
    public Position() {
    }

    /**
     * @param line   line
     * @param column column
     */
    public Position(Integer line, Integer column) {
        this.line.add(line);
        this.column.add(column);
    }

    /**
     * @param position position.
     */
    public void setPosition(Position position) {
        this.line.addAll(position.getLine());
        this.column.addAll(position.getColumn());
    }

    /**
     * @return set integer line word.
     */
    public Set<Integer> getLine() {
        return line;
    }

    /**
     * @return set integer column word.
     */
    public Set<Integer> getColumn() {
        return column;
    }

    /**
     * @return toString.
     */
    @Override
    public String toString() {
        return "Position{line=" + line + ", column=" + column + '}';
    }
}

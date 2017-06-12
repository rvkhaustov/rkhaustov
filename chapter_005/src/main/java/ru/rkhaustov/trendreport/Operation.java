package ru.rkhaustov.trendreport;

import java.util.Calendar;

/**
 * Created by rvkha_000 on 11.06.2017.
 */
public class Operation {
    /**
     * fromState.
     */
    private State fromState;
    /**
     * endState.
     */
    private State endState;
    /**
     * executedDate.
     */
    private Calendar executedDate;

    /**
     * @return executedDate.
     */
    public Calendar getExecutedDate() {
        return executedDate;
    }

    /**
     * @return endState
     */
    public State getEndState() {
        return endState;
    }

    /**
     * @param fromState fromState
     * @param endState endState
     * @param executedDate executedDate
     */
    public Operation(State fromState, State endState, Calendar executedDate) {
        this.fromState = fromState;
        this.endState = endState;
        this.executedDate = executedDate;
    }

}

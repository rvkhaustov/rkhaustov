package ru.rkhaustov.trendreport;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by rvkha_000 on 11.06.2017.
 */
public class Task {
    /**
     * state.
     */
    private State state;
    /**
     * createDate.
     */
    private Calendar createDate;
    /**
     * modificationDate.
     */
    private Calendar modificationDate;
    /**
     * operations.
     */
    private List<Operation> operations;


    /**
     * @param calendar  calendar
     */
    public  void closeTask(Calendar calendar) {
        this.modificationDate = calendar;
        this.state = State.CLOSED;
    }

    /**
     * @return createDate
     */
    public Calendar getCreateDate() {
        return createDate;
    }

    /**
     * @return modificationDate.
     */
    public Calendar getModificationDate() {
              return modificationDate;
    }

    /**
     * @return operations
     */
    public List<Operation> getOperations() {
        return operations;
    }

    /**
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     * @param state state
     * @param createDate createDate
     */
    public Task(State state, Calendar createDate) {
        this.state = state;
        this.createDate = createDate;
        this.modificationDate = createDate;
        this.operations = new ArrayList<>();
    }

    /**
     * @param operation operation
     */
    public void addOperation(Operation operation) {
        operations.add(operation);
    }
}

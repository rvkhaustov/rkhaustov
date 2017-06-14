package ru.rkhaustov.jmm;

/**
 * Created by rvkha_000 on 14.06.2017.
 */
public class Variable {
    /**
     * variable.
     */
    private Integer variable;

    /**
     * @return variable.
     */
    public Integer getVariable() {
        return variable;
    }

    /**
     * @param variable variable.
     */
    public void setVariable(Integer variable) {
        this.variable = variable;
    }

    /**
     * @param variable variable.
     */
    public Variable(Integer variable) {
        this.variable = variable;
    }

    /**
     * @param integer variable
     * @return variable + 1
     */
    public  int add(Integer integer) {
        return  ++integer;
    }

    /**
     * @return variable
     */
    public int add() {
    return ++this.variable;
    }
}

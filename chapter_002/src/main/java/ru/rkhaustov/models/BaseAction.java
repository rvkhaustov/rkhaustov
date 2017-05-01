package ru.rkhaustov.models;

/**
 * BaseAction.
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * @param name - name ite menu.
     */
    private String name;

    /**
     * Construction.
     * @param name name ite menu.
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     *
     * @return string name item menu.
     */
    @Override
    public String info() {
        return String.format(
                "%s. %s",
                this.key(),
                this.name);
    }

    //abstract void execute(Input input, Tracker tracker);


}

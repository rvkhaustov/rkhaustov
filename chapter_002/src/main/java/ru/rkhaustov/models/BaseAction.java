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
     * @param key number item.
     */
    private int key;
    /**
     * Construction.
     * @param key value ite menu.
     * @param name name ite menu.
     */
    public BaseAction(int key, String name) {
        this.name = name;
        this.key = key;
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

    @Override
    public int key() {
        return this.key;
    }
//abstract void execute(Input input, Tracker tracker);


}

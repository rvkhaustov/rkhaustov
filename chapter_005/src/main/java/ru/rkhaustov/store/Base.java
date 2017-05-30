package ru.rkhaustov.store;

/**
 * Created by rvkha_000 on 29.05.2017.
 */
public abstract class Base {
    /**
     * id.
     */
    private String id;

    /**
     * @return get id.
     */
    String getId() {
        return this.id;
    }

    /**
     * @param id set id.
     */
    void setId(String id) {
        this.id = id;
    }
}

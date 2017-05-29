package ru.rkhaustov.store;

/**
 * Created by rvkha_000 on 29.05.2017.
 */
public class User extends Base {
    /**
     * id.
     */
    private String id;

    /**
     * @return get id.
     */
    @Override
    String getId() {
        return this.id;
    }

    /**
     * @param id set id.
     */
    @Override
    void setId(String id) {
        this.id = id;
    }
}

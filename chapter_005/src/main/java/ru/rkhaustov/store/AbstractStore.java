package ru.rkhaustov.store;

import ru.rkhaustov.services.SimpleArray;


/**
 * @param <T> User or Role
 */
public class AbstractStore<T extends Base> implements Store<T> {
    /**
     * simpleArray.
     */
    private SimpleArray<T> simpleArray;

    /**
     * @return SimpleArray.
     */
    public SimpleArray<T> getSimpleArray() {
        return simpleArray;
    }

    /**
     * constructor.
     */
    public AbstractStore() {
        this.simpleArray = new SimpleArray<>(0);
    }

    /**
     * Add Role.
     * @param value add Role.
     */
    @Override
    public void add(T value) {
        simpleArray.add(value);
    }

    /**
     * Delete Role.
     * @param id delete id.
     */
    @Override
    public void delete(String id) {
        int index = getIndex(id);
        if (index != -1) {
            simpleArray.delete(index);
        }

    }

    /**
     * Update Role.
     * @param value Role.
     * @param id id Role
     */
    @Override
    public void update(T value, String id) {
        int index = getIndex(id);
        if (index != -1) {
            this.simpleArray.update(value, index);
        }
    }

    /**
     * @param id idRole
     * @return -1 not found id or index of id Role.
     */
    int getIndex(String id) {
        for (int index = 0; index < this.simpleArray.size(); index++) {
            if (simpleArray.get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }
}

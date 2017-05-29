package ru.rkhaustov.store;

import ru.rkhaustov.services.SimpleArray;

/**
 * Created by rvkha_000 on 29.05.2017.
 */
public class RoleStore implements Store<Role> {
    /**
     * simpleArray.
     */
    private SimpleArray<Role> simpleArray;

    /**
     * @return SimpleArray.
     */
    public SimpleArray<Role> getSimpleArray() {
        return simpleArray;
    }

    /**
     * constructor.
     */
    public RoleStore() {
        this.simpleArray = new SimpleArray<>(0);
    }

    /**
     * Add Role.
     * @param value add Role.
     */
    @Override
    public void add(Role value) {
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
    public void update(Role value, String id) {
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

package ru.rkhaustov.store;

import ru.rkhaustov.services.SimpleArray;

/**
 * Created by rvkha_000 on 29.05.2017.
 */
public class UserStore implements Store<User> {
    /**
     * simpleArray.
     */
    private SimpleArray<User> simpleArray;

    /**
     * @return SimpleArray.
     */
    public SimpleArray<User> getSimpleArray() {
        return simpleArray;
    }

    /**
     * constructor.
     */
    public UserStore() {
        this.simpleArray = new SimpleArray<>(0);
    }

    /**
     * Add User.
     * @param value add User.
     */
    @Override
    public void add(User value) {
        simpleArray.add(value);
    }

    /**
     * Delete User.
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
     * Update User.
     * @param value User.
     * @param id id User
     */
    @Override
    public void update(User value, String id) {
        int index = getIndex(id);
        if (index != -1) {
            this.simpleArray.update(value, index);
        }
    }

    /**
     * @param id idUser
     * @return -1 not found id or index of id User.
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

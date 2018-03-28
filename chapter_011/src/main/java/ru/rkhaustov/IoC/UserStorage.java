package ru.rkhaustov.IoC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rvkha_000 on 25.09.2017.
 */
@Component
public class UserStorage {
    private  final Storage storage;

    @Autowired
    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user){
        this.storage.add(user);
    }
}

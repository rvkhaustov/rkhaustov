package ru.rkhaustov.IoC;

import org.springframework.stereotype.Component;

/**
 * Created by rvkha_000 on 25.09.2017.
 */
@Component
public class MemoryStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("MemoryStorage");
    }
}

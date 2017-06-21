package ru.rkhaustov.threadpool;

import java.util.Random;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class WorkRand implements Work {
    /**
     * doWork.
     */
    @Override
    public void doWork() {
        System.out.println(String.format("Random %s - %s",
                new Random().nextInt(),
                Thread.currentThread().getName()));
    }
}

package ru.rkhaustov.threadpool;

/**
 * Created by rvkha_000 on 20.06.2017.
 */
public class WorkPrint implements Work {
    /**
     * Do work.
     */
    @Override
    public void doWork() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("WorkPrint %s", Thread.currentThread().getName()));
    }
}

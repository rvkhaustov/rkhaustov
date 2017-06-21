package ru.rkhaustov.lock;

import org.junit.Test;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class LockTest {
    /**
     * Test lock.
     * @throws InterruptedException InterruptedException
     */
    @Test
    public void whenLockFalseThenThreadDoWork() throws InterruptedException {
        Lock lock = new Lock();

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    lock.doWork();
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
            }
        };

        t.start();
        Thread.sleep(1000);

        System.out.println("lock = false");
        lock.changeLock(false);

        Thread.sleep(1000);

        System.out.println("lock = true");
        lock.changeLock(true);

        Thread.sleep(1000);

        System.out.println("lock = false");
        lock.changeLock(false);

        t.interrupt();

    }

}
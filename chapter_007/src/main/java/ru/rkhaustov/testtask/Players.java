package ru.rkhaustov.testtask;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 23.11.2017.
 */
public interface Players extends Runnable {


    /**
     * Behavior of the hero.
     *
     * @return  true - block ok, false - lock no.
     */
    boolean fieldMovement();

    /**
     * @param stopThreads setExitThreads
     */
    void setExitThreads(boolean stopThreads);

    /**
     * @param lockBoard lockBoard.
     * @param name      name.
     * @return true - block ok, false - lock no.
     */
    default boolean lockCells(ReentrantLock lockBoard, String name) {

        try {
            System.out.println(name + " trylock.");
            boolean flag = lockBoard.tryLock(500, TimeUnit.MILLISECONDS);
            if (flag) {
                try {

                    System.out.println(name + " lock. ");
                    Thread.sleep(1000);

                } finally {

                    System.out.println(name + " unlock.");
                    lockBoard.unlock();

                    return true;
                }
            } else {
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @param upperBound max namber
     * @return random namber
     */
    static int random(int upperBound) {
        return ThreadLocalRandom.current().nextInt(upperBound);
    }

}

package ru.rkhaustov.testtask;

//import com.sun.org.apache.xpath.internal.operations.String;

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
     * @return true - block ok, false - lock no.
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

            System.out.println(String.format("%s trylock. Time - %s", name, System.currentTimeMillis()));

            boolean flag = lockBoard.tryLock(500, TimeUnit.MILLISECONDS);
            if (flag) {
                try {

                    System.out.println(String.format("%s lock. Time - %s ", name, System.currentTimeMillis()));
                    Thread.sleep(1000);

                } finally {

                    lockBoard.unlock();
                    System.out.println(String.format("%s unlock. Time - %s", name, System.currentTimeMillis()));

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
     * @param item now namber
     * @param upperBound max number
     * @return random namber
     */
    static int random(int item, int upperBound) {
        int random = ThreadLocalRandom.current().nextInt(3000);
        if (random < 1000) {

            return --item <= 0 ? 0 : item;

        } else if (random < 2000) {

            return item;

        } else {

            return ++item > upperBound ? upperBound : item;

        }

    }

}

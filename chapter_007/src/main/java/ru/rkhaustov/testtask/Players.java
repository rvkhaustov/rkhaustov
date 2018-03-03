package ru.rkhaustov.testtask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 23.11.2017.
 */
public interface Players extends Runnable {

    /**
     * Movement player.
     *
     * @throws InterruptedException InterruptedException
     */
    void fieldMovement() throws InterruptedException;

    /**
     * @param stopThreads setExitThreads
     */
    void setExitThreads(boolean stopThreads);

    /**
     * @return ExitThreads
     */
    boolean isExitThreads();


    /**
     * @param x x
     * @param y y
     * @return true ok else false.
     */
    boolean newCell(int x, int y);

    /**
     * @param lockBoard   lockBoard
     * @param name        name
     * @param tryLockTime tryLockTime
     * @param threadSleep threadSleep
     * @return true - block ok, false - lock no.
     * @throws InterruptedException InterruptedException
     */
    public boolean lockCells(final ReentrantLock lockBoard, String name, long tryLockTime, long threadSleep) throws InterruptedException;

    /**
     * @param x - max x
     * @param y - max y
     */
    public void setMaxXY(int x, int y);

    /**
     * @param item       now number
     * @param upperBound max number
     * @return random number
     */
    int random(int item, int upperBound);
}

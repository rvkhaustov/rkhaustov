package ru.rkhaustov.testtask;

/**
 * Created by rvkha_000 on 23.11.2017.
 */
public interface Players extends Runnable {

    /**
     * Movement player.
     * @throws InterruptedException  InterruptedException
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
}

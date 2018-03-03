package ru.rkhaustov.testtask;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 23.11.2017.
 */
public abstract class Base implements Players {

    /**
     * lockBoard.
     */
    private ReentrantLock[][] lockBoard;

    /**
     * max x.
     */
    private static int xMax;

    /**
     * max y.
     */
    private static int yMax;

    /**
     * now x.
     */
    private int xNow;

    /**
     * now y.
     */
    private int yNow;

    /**
     * prev x.
     */
    private int xPrev;

    /**
     * prev y.
     */
    private int yPrev;

    /**
     * exitThreads.
     */
    private boolean exitThreads;

    /**
     * name.
     */
    private final String name;

    /**
     * Behavior of the hero.
     */

    @Override
    public void setExitThreads(boolean exitThreads) {
        this.exitThreads = exitThreads;
    }

    /**
     * @return exitThreads
     */
    public boolean isExitThreads() {
        return exitThreads;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return xMax
     */
    public int getxMax() {
        return xMax;
    }

    /**
     * @return yMax
     */
    public int getyMax() {
        return yMax;
    }

    /**
     * @return xNow
     */
    public int getxNow() {
        return xNow;
    }

    /**
     * @return yNow
     */
    public int getyNow() {
        return yNow;
    }

    /**
     * @return lockBoard
     */
    public ReentrantLock[][] getLockBoard() {
        return lockBoard;
    }

    /**
     * @return lockBoard[this.xNow][this.yNow]
     */
    public ReentrantLock getLockBoardNowXnowY() {
        return lockBoard[this.xNow][this.yNow];
    }

    /**
     * Set now value from prev value.
     */
    public void setNowXYfromPrevXY() {
        this.xNow = this.xPrev;
        this.yNow = this.yPrev;
    }

    /**
     * Set prev value from now value.
     */
    public void setPrevXYfromNowXY() {
        this.xPrev = this.xNow;
        this.yPrev = this.yNow;
    }

    /**
     * @param xNow  xNow
     */
    public void setxNow(int xNow) {
        this.xNow = xNow;
    }

    /**
     * @param yNow yNow
     */
    public void setyNow(int yNow) {
        this.yNow = yNow;
    }

    /**
     * @param x x
     * @param y y
     */
    public void setXandYNow(int x, int y) {
        this.xNow = x;
        this.yNow = y;

    }

    /**
     * @param lockBoard lockBoard
     * @param x         x
     * @param y         y
     * @param name      name
     */
    public Base(ReentrantLock[][] lockBoard, int x, int y, String name) {

        this.lockBoard = lockBoard;
        this.xNow = x;
        this.yNow = y;
        this.exitThreads = false;
        this.name = name;
        this.xPrev = x;
        this.yPrev = y;

    }

    /**
     * @param x - max x
     * @param y - max y
     */
    public void setMaxXY(int x, int y) {
        xMax = x;
        yMax = y;
    }

    /**
     * @param item       now number
     * @param upperBound max number
     * @return random number
     */
    public int random(int item, int upperBound) {
        int random = ThreadLocalRandom.current().nextInt(3000);
        if (random < 1000) {
            return --item <= 0 ? 0 : item;
        } else if (random < 2000) {
            return item;
        } else {
            return ++item > upperBound ? upperBound : item;
        }
    }

    /**
     * @param lockBoard lockBoard
     * @param name name
     * @param tryLockTime tryLockTime
     * @param threadSleep threadSleep
     * @return true - block ok, false - lock no.
     * @throws InterruptedException InterruptedException
     */
    public boolean lockCells(final ReentrantLock lockBoard, String name, long tryLockTime, long threadSleep) throws InterruptedException {
        System.out.println(String.format("%s trylock. Time - %s", name, System.currentTimeMillis()));

        if (lockBoard.tryLock(tryLockTime, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println(String.format("%s lock. Time - %s ", name, System.currentTimeMillis()));
                Thread.sleep(threadSleep);
            } finally {
                lockBoard.unlock();
                System.out.println(String.format("%s unlock. Time - %s", name, System.currentTimeMillis()));
                return true;
            }
        }
        return false;
    }
}

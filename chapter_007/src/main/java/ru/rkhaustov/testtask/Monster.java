package ru.rkhaustov.testtask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 25.01.2018.
 */
public class Monster extends Base {

    /**
     * @param lockBoard lockBoard
     * @param x         x
     * @param y         y
     * @param name      name
     */
    public Monster(ReentrantLock[][] lockBoard, int x, int y, String name) {
        super(lockBoard, x, y, name);
    }

    /**
     * @throws InterruptedException InterruptedException
     */
    public void fieldMovement() throws InterruptedException {
        while (!isExitThreads() && !Thread.currentThread().isInterrupted()) {
            System.out.println(String.format("%s new cell x = %s y = %s. Time %s", getName(), getxNow(), getyNow(), System.currentTimeMillis()));
            if (!lockCells(getLockBoardNowXnowY(), getName(), 500, 1000)) {
                System.out.println(String.format("The hero %s can not lock the cell x = %s y = %s, it is locked. Time %s", getName(), getxNow(), getyNow(), System.currentTimeMillis()));
                setNowXYfromPrevXY();
            }
            newCell(getxNow(), getyNow());
        }
        System.out.println(String.format("%s exitThreads = %s. Time - %s", getName(), isExitThreads(), System.currentTimeMillis()));
    }


    /**
     * @param x x
     * @param y y
     * @return true ok ew cell.
     */
    public boolean newCell(int x, int y) {
        setPrevXYfromNowXY();
        setxNow(random(x, getxMax()));
        setyNow(random(y, getyMax()));
        if (x == getxNow() && y == getyNow()) {
            newCell(x, y);
        }
        return true;
    }

    /**
     * Run thread.
     */
    @Override
    public void run() {
        try {
            fieldMovement();
        } catch (InterruptedException e) {
            System.out.println(String.format("InterruptedException monster: %s", getName()));
        }
    }
}

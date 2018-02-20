package ru.rkhaustov.testtask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 29.01.2018.
 */
public class Bomberman extends Base {


    /**
     * @param lockBoard lockBoard
     * @param x         x
     * @param y         y
     * @param name      name
     */
    public Bomberman(ReentrantLock[][] lockBoard, int x, int y, String name) {
        super(lockBoard, x, y, name);
    }

    /**
     * Behavior of the hero.
     *
     * @return true - block ok, false - lock no.
     */
    @Override
    public void fieldMovement() {
        while (!isExitThreads() && !Thread.currentThread().isInterrupted()) {
        }
        System.out.println(String.format("Bomberman %s exitThreads = %s. Time - %s", getName(), isExitThreads(), System.currentTimeMillis()));
    }

    /**
     * newCell.
     *
     * @param x
     * @param y
     */
    @Override
    public boolean newCell(int x, int y) {
        if ((x >= 0 && x <= getxMax()) && (y >= 0 && y <= getyMax())) {
            if (getLockBoard()[x][y].tryLock()) {
                getLockBoardNowXnowY().unlock();
                setXandYNow(x, y);
                System.out.println(String.format("Bomberman %s unlock new cell x = %s y = %s. Time %s", getName(), getxNow(), getyNow(), System.currentTimeMillis()));
                return true;
            }
            System.out.println(String.format("The Bomberman %s can not lock the cell x = %s y = %s, it is locked. Time %s", getName(), getxNow(), getyNow(), System.currentTimeMillis()));
            return false;
        }
        System.out.println(String.format("The Bomberman %s cell x = %s y = %s no correct. Time %s", getName(), x, y, System.currentTimeMillis()));
        return false;
    }

    @Override
    public void run() {
        fieldMovement();
    }
}

package ru.rkhaustov.testtask;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 23.11.2017.
 */
public class Hero implements Players {

    /**
     * lockBoard.
     */
    private final ReentrantLock[][] lockBoard;


    /**
     * max x.
     */
    private static int maxX;

    /**
     * max y.
     */
    private static int maxY;

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
     * @param lockBoard lockBoard
     * @param x         x
     * @param y         y
     * @param name      name
     */
    public Hero(ReentrantLock[][] lockBoard, int x, int y, String name) {

        this.lockBoard = lockBoard;
        this.xNow = x;
        this.yNow = y;
        this.exitThreads = false;
        this.name = name;

    }

    /**
     * Behavior of the hero.
     *
     * @return true - block ok, false - lock no.
     */
    public boolean fieldMovement() {
        boolean flag = false;

        while (!exitThreads) {
            System.out.println(String.format("%s new cell x = %s y = %s. Time %s", this.name, this.xNow, this.yNow, System.currentTimeMillis()));
            flag = lockCells(this.lockBoard[this.xNow][this.yNow], this.name);
            if (!flag) {

                System.out.println(String.format("The hero %s can not lock the cell x = %s y = %s, it is locked. Time %s", this.name, this.xNow, this.yNow, System.currentTimeMillis()));
                this.xNow = this.xPrev;
                this.yNow = this.yPrev;

            }

            newCell();

        }
        System.out.println(String.format("%s exitThreads = %s. Time - %s", this.name, this.exitThreads, System.currentTimeMillis()));
        return flag;
    }

    /**
     * newCell.
     */
    public void newCell() {

        this.xPrev = this.xNow;
        this.yPrev = this.yNow;

        this.xNow = Players.random(this.xNow, maxX);
        this.yNow = Players.random(this.yNow, maxY);

        if (this.xPrev == this.xNow && this.yPrev == this.yNow) {
            newCell();
        }

    }

    /**
     * Run thread.
     */
    @Override
    public void run() {

        fieldMovement();

    }

    /**
     * @param x - max x
     * @param y - max y
     */
    public static void setMaxXY(int x, int y) {

        maxX = x;
        maxY = y;

    }
}

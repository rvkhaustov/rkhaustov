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
     * cell.
     */
    private Cell cell;

    /**
     * exitThreads.
     */
    private boolean exitThreads;

    /**
     * name.
     */
    private final String name;

    /**
     * @return exitThreads
     */
    public boolean getExitThreads() {
        return exitThreads;
    }

    /**
     * Behavior of the hero.
     */

    @Override
    public void setExitThreads(boolean exitThreads) {
        this.exitThreads = exitThreads;
    }

     /**
     * @param lockBoard lockBoard
     * @param cell cell
     * @param name name
     */
    public Hero(ReentrantLock[][] lockBoard, Cell cell, String name) {
        this.lockBoard = lockBoard;
        this.cell = cell;
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
            System.out.println(String.format("%s новая клетка %s", this.name, this.cell));
            flag = lockCells(this.lockBoard[cell.getX()][cell.getY()], this.name);
            if (!flag) {
                System.out.println(String.format("%s не может заблокировать клетка %s заблокирована", this.name, this.cell));
            }
            newCell();
        }
        System.out.println(String.format("%s exitThreads = %s", this.name, this.exitThreads));
        return flag;
    }

    /**
     * newCell.
     */
    public void newCell() {
        this.cell.putCell(Players.random(cell.getMaxX()), Players.random(cell.getMaxY()));
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        fieldMovement();

    }
}

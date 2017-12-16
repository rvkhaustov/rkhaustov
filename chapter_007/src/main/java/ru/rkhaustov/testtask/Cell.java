package ru.rkhaustov.testtask;

/**
 * Created by rvkha_000 on 24.11.2017.
 */
public class Cell {
    /**
     * x.
     */
    private int x;
    /**
     * y.
     */
    private int y;

    /**
     * maxX.
     */
    private final int maxX;
    /**
     * maxY.
     */
    private final int maxY;


    /**
     * @param x    x
     * @param y    y
     * @param maxX maxX
     * @param maxY maxY
     */
    public Cell(int x, int y, int maxX, int maxY) {
        this.x = x;
        this.y = y;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    /**
     * @return maxX
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * @return maxY
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * @param x x
     * @param y y
     */
    public void putCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Cell{"
                + "x="
                + x
                + ", y="
                + y
                + '}';
    }
}

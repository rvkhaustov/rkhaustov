package ru.rkhaustov.chess;
/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class Cell  {
    /**
     * vertical.
     */
    private int vertical;
    /**
     * horizontal.
     */
    private char horizontal;

    /**
     * @return horizontal.
     */
    public char getHorizontal() {
        return horizontal;
    }

    /**
     * @param horizontal set horizontal.
     */
    public void setHorizontal(char horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * @return vertical
     */
    public int getVertical() {
        return vertical;
    }

    /**
     * @param vertical set vertical.
     */
    public void setVertical(int vertical) {
        this.vertical = vertical;
    }

    /**
     * @param horizontal cell.
     * @param vertical cell.
     */
    public Cell(char horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    /**
     * construction.
     */
    public Cell() {

    }

    /**
     * @param dist dist figure.
     */
    public void clone(Cell dist) {
        this.setHorizontal(dist.getHorizontal());
        this.setVertical(dist.getVertical());
    }


    /**
     * @param obj compare.
     * @return true correct.
     */
    public boolean equals(Cell obj) {
        if (obj == null) {
            return false;
        }
        if (this.horizontal != obj.getHorizontal()) {
            return false;
        }
        if (this.vertical != obj.getVertical()) {
            return false;
        }
        return true;
    }

    /**
     * @return hash cod.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

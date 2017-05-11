package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public abstract  class Figure {
    /**
     * position figure.
     */
    private final Cell position = new Cell();

    /**
     * @return get Cell.
     */
    public Cell getCell() {
        return this.position;
    }

    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public Figure(char horizontal, int vertical) {
        position.setVertical(vertical);
        position.setHorizontal(horizontal);
    }

    /**
     * @param dist figure.
     * @return move figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * @param obj position figure.
     * @return true compare position.
     */
    //@Override
    public boolean equals(Cell obj) {
        if (obj == null) {
            return false;
        }
        if (this.position.getHorizontal() != obj.getHorizontal()) {
            return false;
        }
        if (this.position.getVertical() != obj.getVertical()) {
            return false;
        }
        return true;
    }


    /**
     * @param dist position figure.
     */
    public void clone(Cell dist) {
        position.setHorizontal(dist.getHorizontal());
        position.setVertical(dist.getVertical());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

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
     * cellImpossibleMove.
     */
    private Cell[] cellImpossibleMove = new Cell[64];

    /**
     * indexImpossibleMove.
     */
    private int indexImpossibleMove;

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

    /**
     * @param source source
     * @param dist dist
     * @return Cell[]
     */
    public Cell[] moveVertHorDiag(Cell source, Cell dist) {

        Cell position = this.getCell();

        char sourceX = position.getHorizontal();
        int sourceY = position.getVertical();

        char distX = dist.getHorizontal();
        int distY = dist.getVertical();

        int lag = Math.abs(distY - sourceY) == 0 ? Math.abs(distX - sourceX) : Math.abs(distY - sourceY);
        int stepX, stepY;


        stepX = distX > sourceX ? 1 : distX < sourceX ? -1 : 0;
        stepY = distY > sourceY ? 1 : distY < sourceY ? -1 : 0;

        for (int index = 0; index < lag; index++) {
            sourceX += stepX;
            sourceY += stepY;
            cellImpossibleMove[indexImpossibleMove++] = new Cell(sourceX, sourceY);
        }

        return cellImpossibleMove;
    }


    /**
     * @param indexImpossibleMove set indexImpossibleMove.
     */
    public void setIndexImpossibleMove(int indexImpossibleMove) {
        this.indexImpossibleMove = indexImpossibleMove;
    }
}

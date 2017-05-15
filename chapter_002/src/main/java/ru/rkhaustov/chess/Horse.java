package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class Horse extends Figure {
    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public Horse(char horizontal, int vertical) {
        super(horizontal, vertical);
    }

    /**
     * @param dist figure.
     * @return way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException  {
        Cell[] cellImpossibleMove = new Cell[1];
        Cell position = this.getCell();

        if ((Math.abs(position.getVertical() - dist.getVertical()) == 2
                && Math.abs(position.getHorizontal() - dist.getHorizontal()) == 1)
                || (Math.abs(position.getVertical() - dist.getVertical()) == 1
                && Math.abs(position.getHorizontal() - dist.getHorizontal()) == 2)
                ) {
            cellImpossibleMove[0] = new Cell();
            cellImpossibleMove[0].clone(dist);
        } else {
            throw new ImpossibleMoveException("Impossible Move");
        }

        return cellImpossibleMove;
    }
}

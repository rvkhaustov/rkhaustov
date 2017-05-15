package ru.rkhaustov.chess;

import java.util.Arrays;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class Elephant extends Figure {
    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public Elephant(char horizontal, int vertical) {
        super(horizontal, vertical);
    }

    /**
     * @param dist figure.
     * @return way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException  {
        Cell position = this.getCell();

        char sourceX = position.getHorizontal();
        int sourceY = position.getVertical();

        char distX = dist.getHorizontal();
        int distY = dist.getVertical();

        if (Math.abs(sourceX - distX) != Math.abs(sourceY - distY)) {
            throw new ImpossibleMoveException("Impossible Move");
        }

        this.setIndexImpossibleMove(0);

        return Arrays.copyOf(moveVertHorDiag(this.getCell(), dist), this.getIndexImpossibleMove());

    }
}


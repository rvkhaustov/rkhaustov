package ru.rkhaustov.chess;

import java.util.Arrays;

/**
 * Created by rvkha_000 on 15.05.2017.
 */
public class Queen extends Figure {
    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public Queen(char horizontal, int vertical) {
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

        boolean verticalHorizontal = false;

        if ((sourceX != distX && Math.abs(sourceY - distY) > 0)
                || (sourceY != distY && Math.abs(sourceX - distX) > 0)) {
            verticalHorizontal = true;
        }

        if (verticalHorizontal && (Math.abs(sourceX - distX) != Math.abs(sourceY - distY))) {
            throw new ImpossibleMoveException("Impossible Move");
        }

        this.setIndexImpossibleMove(0);

        return Arrays.copyOf(moveVertHorDiag(this.getCell(), dist), this.getIndexImpossibleMove());

    }
}

package ru.rkhaustov.chess;

/**
 * Created by rvkha_000 on 15.05.2017.
 */
public class King extends Figure {
    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public King(char horizontal, int vertical) {
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

        if (Math.abs(sourceY - distY) > 1 || Math.abs(sourceX - distX) > 1) {
            throw new ImpossibleMoveException("Impossible Move");
        }

        this.setIndexImpossibleMove(0);

        return moveVertHorDiag(this.getCell(), dist);
    }
}

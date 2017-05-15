package ru.rkhaustov.chess;

/**
 * Created by rvkha_000 on 15.05.2017.
 */
public class Pawn extends Figure {
    /**
     * @param horizontal figure.
     * @param vertical figure.
     */
    public Pawn(char horizontal, int vertical) {
        super(horizontal, vertical);
    }
    /**
     * @param dist figure.
     * @return way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException  {
        Cell[] cellImpossibleMove = new Cell[2];
        Cell position = this.getCell();

        char sourceX = position.getHorizontal();
        int sourceY = position.getVertical();

        char distX = dist.getHorizontal();
        int distY = dist.getVertical();



        if ((sourceY == 2) ? (sourceY + 2 != distY && sourceY + 1 != distY) : sourceY + 1 != distY
                || sourceX != distX) {
                throw new ImpossibleMoveException("Impossible Move");
        }
        if (sourceY == 2 && distY == 4) {
            cellImpossibleMove[0] = new Cell(sourceX, sourceY + 1);
            cellImpossibleMove[1] = new Cell();
            cellImpossibleMove[1].clone(dist);
        } else {
            cellImpossibleMove[0] = new Cell();
            cellImpossibleMove[0].clone(dist);
        }

        return cellImpossibleMove;
    }

}

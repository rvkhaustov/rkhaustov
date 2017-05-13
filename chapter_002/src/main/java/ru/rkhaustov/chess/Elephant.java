package ru.rkhaustov.chess;

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
        Cell[] cellImpossibleMove = new Cell[7];
        Cell position = this.getCell();

        char sourceX = position.getHorizontal();
        int sourceY = position.getVertical();

        char distX = dist.getHorizontal();
        int distY = dist.getVertical();

        int lagY = Math.abs(distY - sourceY);

        if (Math.abs(sourceX - distX) != Math.abs(sourceY - distY)) {
            throw new ImpossibleMoveException("Impossible Move");
        }

        if (sourceY < distY) { // up
            if (sourceX < distX) { // left
                for (int index = 0; index < lagY; index++) {
                    cellImpossibleMove[index] = new Cell(++sourceX, ++sourceY);
                }
            } else { // right
                for (int index = 0; index < lagY; index++) {
                    cellImpossibleMove[index] = new Cell(--sourceX, ++sourceY);
                }
            }
        } else { // down
            if (sourceX < distX) { // left
                for (int index = 0; index < lagY; index++) {
                    cellImpossibleMove[index] = new Cell(++sourceX, --sourceY);
                }
            } else { // right
                for (int index = 0; index < lagY; index++) {
                    cellImpossibleMove[index] = new Cell(--sourceX, --sourceY);
                }
            }
        }

        return cellImpossibleMove;
    }
}


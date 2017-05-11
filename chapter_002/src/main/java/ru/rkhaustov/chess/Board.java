package ru.rkhaustov.chess;

/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class Board  {

    /**
     * figures.
     */
    private Figure[] figures = new Figure[32];
    /**
     * figuresCount.
     */
    private int figuresCount = 0;

    /**
     * @param figure - add figure.
     */
    void addFigures(Figure figure)  {
        figures[figuresCount++] = figure;
    }

    /**
     * @param source - from move figure
     * @param dist - to move figure
     * @return true - Successful way.
     * @throws ImpossibleMoveException - Impossible Move.
     * @throws OccupiedWayException - Occupied Way.
     * @throws FigureNotFoundException - FigureNotFound.
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException,
            FigureNotFoundException     {
        int numberFigure = 0;
        int lengthSource = figures.length;
        Cell[] allCell = new Cell[0];
        boolean correctly = false;

        for (; numberFigure < lengthSource; numberFigure++) {
            if (figures[numberFigure] != null && figures[numberFigure].equals(source)) {
                correctly = true;
                break;
            }
        }

        if (correctly) {
            allCell = figures[numberFigure].way(dist); // ImpossibleMoveException
        } else {
            throw new FigureNotFoundException("Figure not Found");
        }

        outterLoop: for (int index = 0;  index < lengthSource; index++) {
            for (int indexAllCell = 0; indexAllCell < allCell.length; indexAllCell++) {
                if (figures[index] != null && figures[index].equals(allCell[indexAllCell])) {
                    correctly = false;
                    break outterLoop;
                }
            }
        }
        if (correctly) {
            figures[numberFigure].clone(dist);
        } else {
            throw new OccupiedWayException("Occipied way.");
        }

        return correctly;
    }
}

package ru.rkhaustov.chess;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class BoardTest {

    /**
     * Test exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('B', 1);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 1);
        Cell cellDist = new Cell('A', 4);

        board.move(cellSource, cellDist);

    }

    /**
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('B', 1);
        board.addFigures(figure);

        figure = new Elephant('A', 3);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 1);
        Cell cellDist = new Cell('A', 3);

        board.move(cellSource, cellDist);
    }
    /**
     * Test exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Elephant('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('A', 3);

        board.move(cellSource, cellDist);
    }
/**
 * Test exception way.
 * @throws ImpossibleMoveException Impossible Move figure.
 */
    @Test
    public void whenWayOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('B', 1);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 3);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell();
        expected[0].clone(cellDist);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }




}
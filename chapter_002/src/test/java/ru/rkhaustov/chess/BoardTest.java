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
     * Test Horse exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testHorseImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Horse('B', 1);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 1);
        Cell cellDist = new Cell('A', 4);

        board.move(cellSource, cellDist);

    }
    /**
     * Test Elephant exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testElephantImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 3);
        Cell cellDist = new Cell('D', 5);

        board.move(cellSource, cellDist);
    }

    /**
     * Test Elephant exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testElephantOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        figure = new Horse('D', 4);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 3);
        Cell cellDist = new Cell('E', 5);

        board.move(cellSource, cellDist);
    }
    /**
     * Test Horse exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testHorseFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Horse('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('A', 3);

        board.move(cellSource, cellDist);
    }
    /**
     * Test Horse exception way.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenHorseWayOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Horse('B', 1);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 3);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell();
        expected[0].clone(cellDist);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * Test Elephant exception way Up Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenElephantWayUpLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('F', 6);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('D', 4);
        expected[1] = new Cell('E', 5);
        expected[2] = new Cell('F', 6);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
   /**
     * Test Elephant exception way Up Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenElephantWayUpRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 5);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('B', 4);
        expected[1] = new Cell('A', 5);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));
    }
  /**
     * Test Elephant exception way Down Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenElephantDownLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('E', 1);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('D', 2);
        expected[1] = new Cell('E', 1);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));
    }
/**
     * Test Elephant exception way Down Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenElephantDownRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Elephant('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 1);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('B', 2);
        expected[1] = new Cell('A', 1);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));
    }




}
package ru.rkhaustov.chess;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * X.1 - ImpossibleMoveException.
 * X.2 - FigureNotFoundException.
 * X.3 - OccupiedWayException.
 * X.4 - test method way Cell[].
 * X = 1 - Horse.
 * X = 2 - Elephant.
 * X = 3 - Pawn.
 * X = 4 - Rook.
 * X = 5 - Queen.
 * X = 6 - King.
 * @author rvkhaustov
 * @version 1.0
 * @since 05.2017
 */
public class BoardTest {

    /**
     * 1.1 Test Horse exception.
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
     * 1.2 Test Horse exception.
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
     * 1.3 Test Horse exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testHorseOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Horse('C', 3);
        board.addFigures(figure);

        figure = new Pawn('D', 5);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 3);
        Cell cellDist = new Cell('D', 5);

        board.move(cellSource, cellDist);
    }

    /**
     * 1.4 Test Horse exception way.
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
     * 2.1 Test Elephant exception.
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
     * 2.2 Test Elephant exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testElephantFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Elephant('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('A', 3);

        board.move(cellSource, cellDist);
    }
    /**
     * 2.3 Test Elephant exception.
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
     * 2.4.1 Test Elephant exception way Up Left.
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
     * 2.4.2 Test Elephant exception way Up Right.
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
     * 2.4.3 Test Elephant exception way Down Left.
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
     * 2.4.4 Test Elephant exception way Down Right.
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

    /**
     * 3.1 Test Pawn exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testPawnImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Pawn('C', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 2);
        Cell cellDist = new Cell('C', 5);


        board.move(cellSource, cellDist);

    }
    /**
     * 3.2 Test Pawn exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testPawnFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Pawn('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('A', 3);

        board.move(cellSource, cellDist);
    }
    /**
     * 3.3 Test Pawn exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testPawnOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Pawn('C', 2);
        board.addFigures(figure);

        figure = new Horse('C', 3);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 2);
        Cell cellDist = new Cell('C', 4);

        board.move(cellSource, cellDist);
    }
    /**
     * 3.4.1 Test Pawn exception way Down Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenPawnHorizMoveTwoThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Pawn('F', 2);
        board.addFigures(figure);

        Cell cellDist = new Cell('F', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('F', 3);
        expected[1] = new Cell('F', 4);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));
    }
    /**
     * 3.4.2 Test Pawn exception way Down Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenPawnHorizMoveOwnThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Pawn('F', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('F', 5);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('F', 5);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 4.1 Test Rook exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testRookImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('B', 1);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 1);
        Cell cellDist = new Cell('F', 5);

        board.move(cellSource, cellDist);

    }
    /**
     * 4.2 Test Rook exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testRookFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Rook('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('B', 4);

        board.move(cellSource, cellDist);
    }   /**
     * 4.3 Test Rook exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testRookOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('C', 2);
        board.addFigures(figure);

        figure = new Horse('C', 5);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 2);
        Cell cellDist = new Cell('C', 8);

        board.move(cellSource, cellDist);
    }
    /**
     * 4.4.1 Test Rook exception way down.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenRookVerticalDownMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 1);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('D', 3);
        expected[1] = new Cell('D', 2);
        expected[2] = new Cell('D', 1);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
    /**
     * 4.4.2 Test Rook exception way up.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenRookUpMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 7);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('D', 5);
        expected[1] = new Cell('D', 6);
        expected[2] = new Cell('D', 7);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }

    /**
     * 4.4.3 Test Rook exception way left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenRookLeftMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('C', 4);
        expected[1] = new Cell('B', 4);
        expected[2] = new Cell('A', 4);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
   /**
     * 4.4.4 Test Rook exception way right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenRookRightMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Rook('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('G', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('E', 4);
        expected[1] = new Cell('F', 4);
        expected[2] = new Cell('G', 4);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
   /**
     * 5.1 Test Queen exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testQueenImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('D', 4);
        board.addFigures(figure);

        Cell cellSource = new Cell('D', 4);
        Cell cellDist = new Cell('E', 6);

        board.move(cellSource, cellDist);

    }
    /**
     * 5.2 Test Queen exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testQueenFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new Queen('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('B', 4);

        board.move(cellSource, cellDist);
    }
    /**
     * 5.3 Test Queen exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testQueenOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('C', 2);
        board.addFigures(figure);

        figure = new Horse('C', 5);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 2);
        Cell cellDist = new Cell('C', 8);

        board.move(cellSource, cellDist);
    }
    /**
     * 5.4.1 Test Queen exception way down.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenVerticalDownMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 1);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('D', 3);
        expected[1] = new Cell('D', 2);
        expected[2] = new Cell('D', 1);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
    /**
     * 5.4.2 Test Queen exception way up.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenUpMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 7);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('D', 5);
        expected[1] = new Cell('D', 6);
        expected[2] = new Cell('D', 7);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
    /**
     * 5.4.3 Test Queen exception way left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenLeftMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('A', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('C', 4);
        expected[1] = new Cell('B', 4);
        expected[2] = new Cell('A', 4);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
   /**
     * 5.4.4 Test Queen exception way right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenRightMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('G', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[3];
        expected[0] = new Cell('E', 4);
        expected[1] = new Cell('F', 4);
        expected[2] = new Cell('G', 4);


        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        assertThat(result[1].getHorizontal(), is(expected[1].getHorizontal()));
        assertThat(result[1].getVertical(), is(expected[1].getVertical()));

        assertThat(result[2].getHorizontal(), is(expected[2].getHorizontal()));
        assertThat(result[2].getVertical(), is(expected[2].getVertical()));
    }
    /**
     * 5.4.5 Test Queen exception way Up Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenWayUpLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('C', 3);
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
     * 5.4.6 Test Queen exception way Up Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenWayUpRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('C', 3);
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
     * 5.4.7 Test Queen exception way Down Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenDownLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('C', 3);
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
     * 5.4.8 Test Queen exception way Down Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenQueenDownRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new Queen('C', 3);
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
/**
     * 6.1 Test King exception.
     * @throws ImpossibleMoveException - impossible move figure.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void testKingImpossibleMoveException() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('D', 4);
        board.addFigures(figure);

        Cell cellSource = new Cell('D', 4);
        Cell cellDist = new Cell('C', 2);

        board.move(cellSource, cellDist);

    }
    /**
     * 6.2 Test King exception.
     * @throws FigureNotFoundException - Figure Not Found figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test (expected = FigureNotFoundException.class)
    public void testKingFigureNotFoundExceptionException() throws FigureNotFoundException, ImpossibleMoveException  {
        Board board = new Board();

        Figure figure = new King('B', 2);
        board.addFigures(figure);

        Cell cellSource = new Cell('B', 3);
        Cell cellDist = new Cell('B', 4);

        board.move(cellSource, cellDist);
    }
    /**
     * 6.3 Test King exception.
     * @throws OccupiedWayException Occupied Way figure.
     * @throws ImpossibleMoveException Impossible Move figure.
     */

    @Test (expected = OccupiedWayException.class)
    public void testKingOccupiedWayExceptionException() throws OccupiedWayException, ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('C', 2);
        board.addFigures(figure);

        figure = new Horse('C', 3);
        board.addFigures(figure);

        Cell cellSource = new Cell('C', 2);
        Cell cellDist = new Cell('C', 3);

        board.move(cellSource, cellDist);
    }
    /**
     * 6.4.1 Test King exception way down.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingVerticalDownMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 3);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('D', 3);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.2 Test King exception way up.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingUpMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 5);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('D', 5);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.3 Test King exception way left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingLeftMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('C', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('C', 4);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));

        }
   /**
     * 6.4.4 Test King exception way right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingRightMoveThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('D', 4);
        board.addFigures(figure);

        Cell cellDist = new Cell('E', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('E', 4);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.5 Test King exception way Up Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingWayUpLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('D', 4);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.6 Test King exception way Up Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingWayUpRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('B', 4);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[1];
        expected[0] = new Cell('B', 4);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.7 Test King exception way Down Left.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingDownLeftOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('D', 2);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('D', 2);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }
    /**
     * 6.4.8 Test King exception way Down Right.
     * @throws ImpossibleMoveException Impossible Move figure.
     */
    @Test
    public void whenKingDownRightOutputCorrectThenTrue() throws ImpossibleMoveException {
        Board board = new Board();

        Figure figure = new King('C', 3);
        board.addFigures(figure);

        Cell cellDist = new Cell('B', 2);

        Cell[] result = figure.way(cellDist);
        Cell[] expected = new Cell[2];
        expected[0] = new Cell('B', 2);

        assertThat(result[0].getHorizontal(), is(expected[0].getHorizontal()));
        assertThat(result[0].getVertical(), is(expected[0].getVertical()));
    }


}
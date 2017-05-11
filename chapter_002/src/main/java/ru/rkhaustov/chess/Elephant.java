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
        Cell[] cellImpossibleMove = new Cell[1];
        Cell position = this.getCell();

        char horizontal;
        int vertical;
        boolean checkFlagImpossible = true;

        //1. move up vertical
        vertical =  position.getVertical() + 2;

        //1.1 right horizontal
        horizontal = position.getHorizontal();
        horizontal++;
        Cell checkImpossible = new Cell(horizontal, vertical);

        if (checkImpossible.equals(dist)) {
            checkFlagImpossible = false;

        }

        //1.2 left horizontal
        horizontal = position.getHorizontal();
        horizontal--;
        checkImpossible.setHorizontal(horizontal);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //2. move down vertical
        vertical = position.getVertical() - 2;
        checkImpossible.setVertical(vertical);

        //2.1 right horizontal
        horizontal = position.getHorizontal();
        horizontal++;
        checkImpossible.setHorizontal(horizontal);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //2.2 left horizontal
        horizontal = position.getHorizontal();
        horizontal--;
        checkImpossible.setHorizontal(horizontal);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //3. move left horizontal
        horizontal = position.getHorizontal();
        horizontal--;
        horizontal--;
        checkImpossible.setHorizontal(horizontal);

        //3.1 up vertical
        vertical = position.getVertical() + 1;
        checkImpossible.setVertical(vertical);
        checkImpossible.setVertical(vertical);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //3.2 down vertical
        vertical = position.getVertical() - 1;
        checkImpossible.setVertical(vertical);
        checkImpossible.setVertical(vertical);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //4. move right horizontal
        horizontal = position.getHorizontal();
        horizontal++;
        horizontal++;
        checkImpossible.setHorizontal(horizontal);

        //4.1 up vertical
        vertical = position.getVertical() + 1;
        checkImpossible.setVertical(vertical);
        checkImpossible.setVertical(vertical);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }

        //4.2 down vertical
        vertical = position.getVertical() - 1;
        checkImpossible.setVertical(vertical);
        checkImpossible.setVertical(vertical);
        if (checkFlagImpossible && checkImpossible.equals(dist)) {
            checkFlagImpossible = false;
        }


        System.out.println(checkFlagImpossible);
        if (checkFlagImpossible) {
            throw new ImpossibleMoveException("Impossible Move");
        }
        cellImpossibleMove[0] = new Cell();
        cellImpossibleMove[0].clone(dist);

        System.out.println(cellImpossibleMove[0].getHorizontal() + " " + cellImpossibleMove[0].getVertical());

        return cellImpossibleMove;
    }
}

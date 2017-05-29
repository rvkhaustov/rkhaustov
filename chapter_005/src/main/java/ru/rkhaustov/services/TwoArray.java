package ru.rkhaustov.services;

import java.util.Iterator;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class TwoArray implements Iterable {

    /**
     * arrayTwo.
     */
    private final int[][] arrayTwo;

    /**
     * indexFirst.
     */
    private int indexFirst = 0;
    /**
     * indexSecond.
     */
    private int indexSecond = 0;


    /**
     * @param arrayTwo arrayTwo
     */
    public TwoArray(int[][] arrayTwo) {
        this.arrayTwo = arrayTwo;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        return new TwoArrayIterator();
    }

    /**
     * Iterator.
     */
    public class TwoArrayIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return (arrayTwo[indexFirst].length == indexSecond)
                    ? indexFirst + 1 < arrayTwo.length && arrayTwo[indexFirst].length > 0
                    : indexFirst < arrayTwo.length && arrayTwo[indexFirst].length > indexSecond;
        }


        @Override
        public Object next() {
            if (arrayTwo[indexFirst].length == indexSecond) {
                indexFirst++;
                indexSecond = 0;
            }
            return arrayTwo[indexFirst][indexSecond++];
        }
    }

}

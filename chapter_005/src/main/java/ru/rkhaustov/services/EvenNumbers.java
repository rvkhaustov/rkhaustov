package ru.rkhaustov.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class EvenNumbers implements Iterable {
    /**
     * arrayTwo.
     */
    private final int[] array;

    /**
     * position.
     */
    private int position = 0;


    /**
     * @param array array.
     */
    public EvenNumbers(int[] array) {
        this.array = array;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        return new EvenNumbers.EvenNumbersIterator();
    }

    /**
     * Iterator.
     */
    public class EvenNumbersIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return even() == -1 ? false : true;
        }

        @Override
        public Object next() {
            position = even();
            if (position == -1) {
                throw new NoSuchElementException();
            }
            return array[position++];
        }

        /**
         * @return -1 not even number or index even number
         */
        int even() {
            for (int index = position; index < array.length; index++) {
                if (array[index] % 2 == 0) {
                    return index;
                }
            }
            return -1;
        }
    }
}

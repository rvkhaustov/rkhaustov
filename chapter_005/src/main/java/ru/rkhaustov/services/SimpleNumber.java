package ru.rkhaustov.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class SimpleNumber implements Iterable {
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
    public SimpleNumber(int[] array) {
        this.array = array;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        return new SimpleNumber.SimpleNumberIterator();
    }

    /**
     * Iterator.
     */
    public class SimpleNumberIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return simpleNumb() == -1 ? false : true;
        }

        @Override
        public Object next() {
            position = simpleNumb();
            if (position == -1) {
                throw new NoSuchElementException();
            }
            return array[position++];
        }

        /**
         * @return -1 if no simple number else position simple number
         */
        int simpleNumb() {
            int number = 0;
            int index = position;
            boolean simpleNumber = false;
            for (; (index < array.length && !simpleNumber); index++) {
                number = array[index];
                simpleNumber = true;
                if (number <= 1) {
                    simpleNumber = false;
                    continue;
                } else if (number == 2 || number == 3) {
                    return index;
                } else {
                    for (int indexSimple = 2; indexSimple * indexSimple <= number; indexSimple++) {
                        if (number % indexSimple == 0) {
                            simpleNumber = false;
                            break;
                        }
                    }
                }
            }
            return simpleNumber ? index - 1 : -1;
        }
    }
}

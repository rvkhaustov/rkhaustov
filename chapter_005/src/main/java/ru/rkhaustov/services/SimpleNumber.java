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
    private final int[][] arrayTwo;

    /**
     * @return IndexFirst.
     */
    public int getIndexFirst() {
        return indexFirst;
    }

    /**
     * @return getIndexSecond.
     */
    public int getIndexSecond() {
        return indexSecond;
    }

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
    public SimpleNumber(int[][] arrayTwo) {
        this.arrayTwo = arrayTwo;
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
            int indexFirstHas = getIndexFirst();
            int indexSecondHas = getIndexSecond();

            while (hasNextAll(indexFirstHas, indexSecondHas)) {
                if (arrayTwo[indexFirstHas].length == indexSecondHas) {
                    indexFirstHas++;
                    indexSecondHas = 0;
                }
                if (simpleNumb(arrayTwo[indexFirstHas][indexSecondHas])) {
                    return true;
                }
                indexSecondHas++;
            }
            return false;
        }

        /**
         * @param indexFirstAll indexFirstAll
         * @param indexSecondAll indexSecondAll
         * @return false or true
         */
        public boolean hasNextAll(int indexFirstAll, int indexSecondAll) {
            if (arrayTwo[indexFirstAll].length == indexSecondAll) {
                indexFirstAll++;
                indexSecondAll = 0;
            }
            return indexFirstAll < arrayTwo.length
                    && arrayTwo[indexFirstAll].length > indexSecondAll;
        }


        @Override
        public Object next() {
            while (hasNextAll(indexFirst, indexSecond)) {
                if (arrayTwo[indexFirst].length == indexSecond) {
                    indexFirst++;
                    indexSecond = 0;
                }
                if (simpleNumb(arrayTwo[indexFirst][indexSecond])) {
                    return arrayTwo[indexFirst][indexSecond++];
                }
                indexSecond++;
            }
            throw new NoSuchElementException();
        }
    }

    /**
     * @param number number
     * @return true if simple number
     */
   boolean simpleNumb(int number) {
        if (number <= 1) {
            return false;
        } else if (number == 2 || number == 3) {
            return true;
        } else {
            for (int index = 2; index * index <= number; index++) {
                if (number % index == 0) {
                    return false;
                }
            }
        }
        return true;

   }
}

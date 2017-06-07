package ru.rkhaustov.sorting;

import ru.rkhaustov.list.LinkedArray;

import java.util.Arrays;


/**
 * Created by rvkha_000 on 06.06.2017.
 * @param <T> T.
 */

public class BinSort<T extends Comparable> {
    /**
     * arrayASC.
     */
    private LinkedArray<T> arrayASC;

    /**
     * @return arrayASC
     */
    public LinkedArray<T> getArrayASC() {
        return arrayASC;
    }

    /**
     * constructor.
     */
    public BinSort() {
        this.arrayASC = new LinkedArray<T>();
    }

    /**
     * @param firstT first array
     * @param secondV second array
     */
    public void add(T[] firstT, T[] secondV) {
        int countSortT = isSort(firstT);
        int countSortV = isSort(secondV);
        if (countSortT >= countSortV) {
        pull(firstT, countSortT, secondV);
        } else {
            pull(secondV, countSortV, firstT);
        }
    }

    /**
     * @param arrayFirst array first
     * @param countSortF count size sort ASC symbol
     * @param arraySecond  array second
     */
    public void pull(T[] arrayFirst, int countSortF, T[] arraySecond) {

        if (countSortF != 0) {
            for (int index = 0; index < arrayFirst.length; index++) {
                arrayASC.add(arrayFirst[index]);
            }
            if (countSortF != arrayFirst.length) {
                binarysSort(Arrays.copyOfRange(arrayFirst, countSortF, arrayFirst.length));
            }
        } else  {
            binarysSort(arrayFirst);
        }
            binarysSort(arraySecond);
        }


    /**
     * @param array array for check sort ASC.
     * @return number sort ASC symbol
     */
    public int isSort(T[] array) {
        if (array.length > 1 && array[0].compareTo(array[1]) <= 0) {
            int index = 2;
            for (; index < array.length; index++) {
                if (array[index - 1].compareTo(array[index]) > 0) {
                    return index;
                }
            }
            return index;
        }
        return 0;
    }

    /**
     * @param arrayNoSort array
     */
    public  void binarysSort(T[] arrayNoSort) {
        int index = 0;
        if (arrayASC.size() == 0) {
            arrayASC.add(arrayNoSort[index++]);
        }
        for (; index < arrayNoSort.length; index++) {
            int left = 0;
            int right = arrayASC.size() - 1;
            int asc = 0;
            while (left <= right) {
                int middle = (left + right) >> 1;
                asc = arrayASC.get(middle).compareTo(arrayNoSort[index]);
                if (asc < 0) {
                    left = middle + 1;
                } else if (asc > 0) {
                    right = middle - 1;
                } else {
                    arrayASC.add(middle, arrayNoSort[index]);
                    break;
                }
            }
            if (asc != 0) {
                arrayASC.add(left, arrayNoSort[index]);
            }
        }
    }
}

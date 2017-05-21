package ru.rkhaustov.conversion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rvkha_000 on 19.05.2017.
 */
public class ConvertList {

    /**
     * @param array int[][] array
     * @return List collection
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<Integer>();
        for (int[] indexFirst : array) {
            for (int indexSecond : indexFirst) {
                list.add(indexSecond);
            }
        }
        return list;
    }

    /**
     * @param list List collection.
     * @param rows size array.
     * @return array int[][].
     */
    public int[][] toArray(List<Integer> list, int rows) {

        int size = (rows == 0) ? 0 : list.size() / rows + ((list.size() % rows == 0) ? 0 : 1);

        int[][] arrayInt = new int[size][rows];
        int value = 0;
        Iterator<Integer> iterator = list.iterator();
        for (int indexFirst = 0; indexFirst < size; indexFirst++) {
            for (int indexSecond = 0; indexSecond < rows; indexSecond++) {
                value = iterator.hasNext() ? iterator.next() : 0;
                arrayInt[indexFirst][indexSecond] = value;
            }

        }
        return arrayInt;
    }

    /**
     * @param list int[] collection
     * @return list Integer
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> listInteger = new ArrayList<>();

//        for (int indexFist = 0; indexFist < list.size(); indexFist++) {
//            for (int indexSecond : list.get(indexFist)) {
//                listInteger.add(indexSecond);
//            }
//        }
        for (int[] indexFist : list) {
            for (int indexSecond : indexFist) {
                listInteger.add(indexSecond);
            }
        }
        return listInteger;
    }
}


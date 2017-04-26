package ru.rkhaustov.array;

/**
* @author Roman Khaustov
* @version 1.0
* @since 04.2017
*/
public class SortTwoArray {
    /**
    * Method sort.
    * @param arrayFirst -  1 sort array
    * @param arraySecond -  2 sort array
    * @return sort array = arrayFirst + arraySecond
    */
    public int[] sort(int[] arrayFirst, int[] arraySecond) {
        int lengthFirst = arrayFirst.length;
        int lengthSecond = arraySecond.length;
        int indexFirst = 0;
        int indexSecond = 0;
        int indexFird = 0;
        int[] arrayThird = new int[lengthFirst + lengthSecond];
        for (; indexFirst < lengthFirst && indexSecond < lengthSecond; indexFird++) {
            arrayThird[indexFird] = (arrayFirst[indexFirst] < arraySecond[indexSecond])
                                   ? arrayFirst[indexFirst++] : arraySecond[indexSecond++];
            }
        for (int index = indexFird; indexFirst < lengthFirst || indexSecond < lengthSecond; index++) {
            arrayThird[index] = (indexFirst >= lengthFirst) ? arraySecond[indexSecond++] : arrayFirst[indexFirst++];
        }
        return arrayThird;
    }
}
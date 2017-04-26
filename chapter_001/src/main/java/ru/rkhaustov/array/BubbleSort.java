package ru.rkhaustov.array;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class BubbleSort {
/**
  * Method BubbleSort.
  * @param array array
  * @return array
  */
public int[] sort(int[] array) {
int value;
for (int first = 0; first < array.length; first++) {
        for (int second = 0; second < array.length - 1; second++) {
            value = array[second];
            if (value > array[second + 1]) {
                array[second] = array[second + 1];
                array[second + 1] = value;
            }
        }
    }
return array;
}
}
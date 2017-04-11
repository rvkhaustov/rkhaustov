package ru.job4j.array;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class Turn {
  /**
  * Method back.
  * @param array array
  * @return array
  */
    public int[] back(int[] array) {
        int value;
        int lengthArray = array.length;
      for (int index = 0; index < lengthArray / 2; index++) {
            value = array[index];
            array[index] = array[lengthArray - index - 1];
            array[lengthArray - index - 1] = value;
        }
    return array;
    }
}

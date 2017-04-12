package ru.job4j.array;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class RotateArray {
    /**
    * Method rotate.
    * @param array array
    * @return int [][]
    */
    public int[][] rotate(int[][] array) {
        int value;
        int length = array[0].length - 1;
        for (int i = 0; i < array[0].length / 2; i++) {
            for (int j = i; j < length - i; j++) {
                value = array[i][j]; // 0.0
                array[i][j] = array[length - j][i]; // 0,0 <- 1,0
                array[length - j][i] = array[length - i][length - j]; //1,0 <- 1,1
                array[length - i][length - j] = array[j][length - i]; // 1,1 <- 0,1
                array[j][length - i] = value; // 0,1
            }
        }
        return array;
    }
}
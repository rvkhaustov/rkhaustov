package ru.job4j.array;
import java.util.Arrays;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class ArrayDuplicate {
     /**
    * Method remove.
    * @param array array
    * @return String[]
    */
    public String[] remove(String[] array) {
        int length = array.length;
        int duplicate = array.length - 1;
        String valueStr;
        for (int indexUnique = 0; indexUnique < length; indexUnique++) {
            for (int indexAll = indexUnique + 1; indexAll < duplicate; indexAll++) {
                if (array[indexUnique] == array[indexAll]) {
                    valueStr = array[indexAll];
                    array[indexAll] = array[duplicate];
                    array[duplicate--] = valueStr;
                    indexAll--;
                }
            }
        }
        return Arrays.copyOf(array, duplicate + 1);
    }
}
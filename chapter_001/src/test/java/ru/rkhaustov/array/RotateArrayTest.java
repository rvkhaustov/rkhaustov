package ru.rkhaustov.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class RotateArrayTest {
     /**
   * Test rotate.
   */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        int[][] array = {{1, 2},
                         {3, 4}};
        int[][] expected = {{3, 1},
                            {4, 2}
        };
        RotateArray rotatearray = new RotateArray();
        rotatearray.rotate(array);
        assertThat(array, is(expected));
    }
 /**
   * Test rotate.
   */
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        int[][] array = {{1, 2, 3},
                         {4, 5, 6},
                         {7, 8, 9}
        };
        int[][] expected = {{7, 4, 1},
                            {8, 5, 2},
                            {9, 6, 3}
        };
        RotateArray rotatearray = new RotateArray();
        rotatearray.rotate(array);
        assertThat(array, is(expected));
    }
}

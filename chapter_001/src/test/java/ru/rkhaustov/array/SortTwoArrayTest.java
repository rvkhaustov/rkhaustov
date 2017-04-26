package ru.rkhaustov.array;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* @author Roman khaustov
* @version 1.0
* @since 04.2017
*/
public class SortTwoArrayTest {
   /**
   * Test method Sort.
   */
    @Test
    public void whenSortTwoArrayThenSortArray() {
        SortTwoArray sortTwoArray = new SortTwoArray();
        int[] arrayFirst = {1, 3, 5};
        int[] arraySecond = {2, 4, 5, 7};
        int[] result = sortTwoArray.sort(arrayFirst, arraySecond);
        int[] expected = {1, 2, 3, 4, 5, 5, 7};
        assertThat(result, is(expected));
    }
}
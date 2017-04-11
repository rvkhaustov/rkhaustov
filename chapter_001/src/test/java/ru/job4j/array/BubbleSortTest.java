package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class BubbleSortTest {
    /**
   * Test back.
   */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort bubleSort = new BubbleSort();
        int[] result = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        result = bubleSort.sort(result);
        int[] expected = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expected));
    }
}

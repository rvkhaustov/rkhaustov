package ru.rkhaustov.conversion;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rvkha_000 on 19.05.2017.
 */
public class ConvertListTest {

    /**
     * Test ToArray.
     */
    @Test
    public void whenToArraySetCollectionThenGetArray() {

        ConvertList convertList = new ConvertList();
        int[][] expected = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 0}
        };
        List<Integer> list = new ArrayList<Integer>();
        for (int index = 0; index < 14; index++) {
            list.add(index);
        }
        int[][] result =   convertList.toArray(list, 5);
        assertThat(result, is(expected));
    }
    /**
     * Test ToList.
     */
    @Test
    public void whenToListSetArrayThenGetCollection() {

        ConvertList convertList = new ConvertList();
        int[][] array = {
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13}
        };
        List<Integer> expectedList = new ArrayList<Integer>();
        for (int index = 0; index < 14; index++) {
            expectedList.add(index);
        }
        List<Integer> result =   convertList.toList(array);
        assertThat(result, is(expectedList));
    }


}
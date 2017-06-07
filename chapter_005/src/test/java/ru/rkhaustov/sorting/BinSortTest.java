package ru.rkhaustov.sorting;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 06.06.2017.
 */
public class BinSortTest {
    /**
     * Method add.
     */
    @Test
    public void whenAddTwoNoSortArraysTestOwnSortArray() {
        Integer[] integerNoSortFirst = {1, 0, 2};
        Integer[] integerNoSortSecond = {5, 4, 3, 2};

        BinSort<Integer> binSort = new BinSort<>();
        binSort.add(integerNoSortFirst, integerNoSortSecond);

        assertThat(binSort.getArrayASC().get(0), is(0));
        assertThat(binSort.getArrayASC().get(1), is(1));
        assertThat(binSort.getArrayASC().get(2), is(2));
        assertThat(binSort.getArrayASC().get(3), is(2));
        assertThat(binSort.getArrayASC().get(4), is(3));
        assertThat(binSort.getArrayASC().get(5), is(4));
        assertThat(binSort.getArrayASC().get(6), is(5));
    }
    /**
     * Method add.
     */
    @Test
    public void whenAddOwnSortArraysTestOwnSortArra1() {
        Integer[] integerSortFirst = {0, 1, 10};
        Integer[] integerNoSortSecond = {5, 3, 6, 1};

        BinSort<Integer> binSort = new BinSort<>();
        binSort.add(integerSortFirst, integerNoSortSecond);

        assertThat(binSort.getArrayASC().get(0), is(0));
        assertThat(binSort.getArrayASC().get(1), is(1));
        assertThat(binSort.getArrayASC().get(2), is(1));
        assertThat(binSort.getArrayASC().get(3), is(3));
        assertThat(binSort.getArrayASC().get(4), is(5));
        assertThat(binSort.getArrayASC().get(5), is(6));
        assertThat(binSort.getArrayASC().get(6), is(10));
    }
    /**
     * Method add.
     */
    @Test
    public void whenAddTwoSortArraysTestOwnSortArray() {
        Integer[] integerSortFirst = {0, 1, 10};
        Integer[] integerSortSecond = {1, 3, 5, 6};

        BinSort<Integer> binSort = new BinSort<>();
        binSort.add(integerSortFirst, integerSortSecond);

        assertThat(binSort.getArrayASC().get(0), is(0));
        assertThat(binSort.getArrayASC().get(1), is(1));
        assertThat(binSort.getArrayASC().get(2), is(1));
        assertThat(binSort.getArrayASC().get(3), is(3));
        assertThat(binSort.getArrayASC().get(4), is(5));
        assertThat(binSort.getArrayASC().get(5), is(6));
        assertThat(binSort.getArrayASC().get(6), is(10));
    }
    /**
     * Method isSort.
     */
    @Test
    public void whenIsSortSortArraysThenSizeArraySort() {
        Integer[] integerSort = {1, 3, 5, 6};

        BinSort<Integer> binSort = new BinSort<>();

        assertThat(binSort.isSort(integerSort), is(4));
    }
    /**
     * Method isSort.
     */
    @Test
    public void whenIsSortSortArraysThreeSymblThenSizeArray3() {
        Integer[] integerSort = {1, 3, 5, 0, 100};

        BinSort<Integer> binSort = new BinSort<>();

        assertThat(binSort.isSort(integerSort), is(3));
    }
    /**
     * Method isSort.
     */
    @Test
    public void whenIsSortNoSortArraysThenSize0() {
        Integer[] integerSort = {3, 1, 10, 6, 5};

        BinSort<Integer> binSort = new BinSort<>();

        assertThat(binSort.isSort(integerSort), is(0));
    }

    /**
     * Method binarysSort.
     */
    @Test
    public void whenBinarysSortNoSortArrayThanSortArray() {
        Integer[] integerSort = {10, 20, 5, 6, 1};

        BinSort<Integer> binSort = new BinSort<>();
        binSort.binarysSort(integerSort);

        assertThat(binSort.getArrayASC().get(0), is(1));
        assertThat(binSort.getArrayASC().get(1), is(5));
        assertThat(binSort.getArrayASC().get(2), is(6));
        assertThat(binSort.getArrayASC().get(3), is(10));
        assertThat(binSort.getArrayASC().get(4), is(20));
    }
}
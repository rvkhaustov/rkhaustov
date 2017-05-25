package ru.rkhaustov.directory;

import org.junit.Test;

import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashSet;
//import java.util.Comparator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rvkha_000 on 25.05.2017.
 */
public class UnitsTest {
    /**
     * Test sortDESC.
     */
    @Test
    public void whenSortDESCSetListThenGetTreeSet() {
        List<String> lists = new ArrayList<>();
        lists.addAll(Arrays.asList("K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        ));
        Set<String> expected = new LinkedHashSet<>();
        expected.addAll(Arrays.asList(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"

        ));
        assertThat(new Units().sortDESC(lists), is(expected));
    }
    /**
     * Test sortASC.
     */
    @Test
    public void whenSortASCSetListThenGetTreeSet() {
        List<String> lists = new ArrayList<>();
        lists.addAll(Arrays.asList("K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        ));
        Set<String> expected = new LinkedHashSet<>();
        expected.addAll(Arrays.asList(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"


        ));
        assertThat(new Units().sortASC(lists), is(expected));
    }
}
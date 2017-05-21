package ru.rkhaustov.sorting;



import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;


import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class SortUserTest {
    /**
     * Test sort.
     */
    @Test
    public void whenSortSetListThenGetTreeSet() {
        List<User> list = new ArrayList<User>();
        list.addAll(Arrays.asList(new User("Igor", 40),
                new User("Miha", 30),
                new User("Oleg", 50)));
        Set<User> listExpected = new TreeSet<>();
        listExpected.addAll(Arrays.asList(new User("Miha", 30),
                new User("Igor", 40),
                new User("Oleg", 50)));
        assertThat(new SortUser().sort(list), is(listExpected));
    }

}
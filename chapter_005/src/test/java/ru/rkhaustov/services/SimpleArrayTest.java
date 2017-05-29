package ru.rkhaustov.services;

import org.junit.Test;

//import java.util.Arrays;
//
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 29.05.2017.
 */
public class SimpleArrayTest {

    /**
     * test String.
     */
    @Test
    public void  whenSetStringThenGetString() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("test");
        String result = simpleArray.get(0);

        assertThat(result, is("test"));
    }

    /**
     * test Integer.
     */
    @Test
    public void  whenSetIntegerThenGetInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(4);
        simpleArray.add(2);
        Integer result = simpleArray.get(0);

        assertThat(result, is(2));
    }

    /**
     * update.
     */
    @Test
    public void  whenUpdateArrayThenCorrectUpdate() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);

        simpleArray.add(2);
        simpleArray.add(5);
        simpleArray.update(4, 0);

        Integer result = simpleArray.get(0);

        assertThat(result, is(4));
    }
    /**
     * delete.
     */
    @Test
    public void  whenDeleteThenCorrectDelete() {
        SimpleArray<Integer> simpleArray = new SimpleArray<Integer>(0);

        simpleArray.add(6);
        simpleArray.add(5);
        simpleArray.add(4);

        simpleArray.delete(1);

        assertThat(simpleArray.get(0), is(6));
        assertThat(simpleArray.get(1), is(4));
    }



}
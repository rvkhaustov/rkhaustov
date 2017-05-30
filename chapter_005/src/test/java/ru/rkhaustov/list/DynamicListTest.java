package ru.rkhaustov.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 30.05.2017.
 */
public class DynamicListTest {
    /**
     * test method add and get <String>.
     */
    @Test
    public void  whenAddStringThenGetString() {
        SimpleContainer<String> list = new DynamicList<>(0);

        list.add("test");
        String result = list.get(0);

        assertThat(result, is("test"));
    }
    /**
     * test method next() <Integer>.
     */
    @Test
    public void whenNextThenPointerForward() {
        SimpleContainer<Integer> list = new DynamicList<>(0);

        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Iterator<Integer> iterator = list.iterator();

        int result = iterator.next();
        assertThat(result, is(4));

        result = iterator.next();
        assertThat(result, is(3));

        result = iterator.next();
        assertThat(result, is(2));

        result = iterator.next();
        assertThat(result, is(1));
    }
    /**
     * Test hasNext() <Float>.
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        SimpleContainer<Float> list = new DynamicList<>(100);

        list.add(4f);
        list.add(3f);


        Iterator<Float> iterator = list.iterator();

        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }
}
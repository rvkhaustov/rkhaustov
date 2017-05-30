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
        DynamicList<String> dynamicList = new DynamicList<>(0);

        dynamicList.add("test");
        String result = dynamicList.get(0);

        assertThat(result, is("test"));
    }
    /**
     * test method next() <Integer>.
     */
    @Test
    public void whenNextThenPointerForward() {
        DynamicList<Integer> dynamicList = new DynamicList<>(new Integer[] {4, 3, 2, 1});
        Iterator<Integer> iterator = dynamicList.iterator();

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
        DynamicList<Float> dynamicList = new DynamicList<>(new Float[] {4f, 3f});
        Iterator<Float> iterator = dynamicList.iterator();

        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }
}
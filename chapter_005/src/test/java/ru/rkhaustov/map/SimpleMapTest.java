package ru.rkhaustov.map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 01.06.2017.
 */
public class SimpleMapTest {
    /**
     * Method Insert.
     */
    @Test
    public void whenInsertThenGet() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();

        simpleMap.insert(null, "1");
        simpleMap.insert(null, "2");
        simpleMap.insert("100", "102");
        simpleMap.insert("sgsgdg", "500");

        assertThat(simpleMap.insert("second", "second"), is(true));
        //        assertThat(simpleMap.delete("sgsgdg"),

        assertThat(simpleMap.get(null), is("2"));
        assertThat(simpleMap.get("100"), is("102"));

    }
    /**
     * Method Delete.
     */
    @Test
    public void whenDeleteThenTrue() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();

        simpleMap.insert(null, "1");
        simpleMap.insert(null, "2");
        simpleMap.insert("100", "102");
        simpleMap.insert("sgsgdg", "500");

        assertThat(simpleMap.get("sgsgdg"), is("500"));
        assertThat(simpleMap.delete("sgsgdg"), is(true));
        String expected = null;

        assertThat(simpleMap.get("sgsgdg"), is(expected));
    }
    /**
     * test method next().
     */
    @Test
    public void whenNextThenPointerForward() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();

        simpleMap.insert(null, "1");
        simpleMap.insert("100", "102");
        simpleMap.insert("600", "602");

        Iterator<String> iterator = simpleMap.iterator();

        String result = iterator.next();
        assertThat(result, is("1"));

        result = iterator.next();
        assertThat(result, is("102"));

        result = iterator.next();
        assertThat(result, is("602"));

    }
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        SimpleMap<String, String> simpleMap = new SimpleMap<>();

        simpleMap.insert(null, "1");
        simpleMap.insert("100", "102");
        simpleMap.insert("600", "602");

        Iterator<String> iterator = simpleMap.iterator();
        iterator.next();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();
        assertThat(result, is(false));
    }

}
package ru.rkhaustov.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class SimpleNumberTest {
    /**
     * Test next().
     */
    @Test
    public void whenNextThenPointerForward() {
        SimpleNumber simpleNumber = new SimpleNumber(new int[]{1, 2, 3, 4, 5, 6, 977, 1000});

        int result = (Integer) simpleNumber.iterator().next();
        assertThat(result, is(2));

        result = (Integer) simpleNumber.iterator().next();
        assertThat(result, is(3));

        result = (Integer) simpleNumber.iterator().next();
        assertThat(result, is(5));

        result = (Integer) simpleNumber.iterator().next();
        assertThat(result, is(977));
    }
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        SimpleNumber simpleNumber = new SimpleNumber(new int[]{1, 2, 3, 4, 5, 8});

        simpleNumber.iterator().next();
        simpleNumber.iterator().next();
        simpleNumber.iterator().next();

        boolean result = simpleNumber.iterator().hasNext();

        assertThat(result, is(false));
    }

}
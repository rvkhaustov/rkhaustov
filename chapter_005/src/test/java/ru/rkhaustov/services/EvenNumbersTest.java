package ru.rkhaustov.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class EvenNumbersTest {
    /**
     * Test next().
     */
    @Test
    public void whenNextThenPointerForward() {
        EvenNumbers evenNumbers = new EvenNumbers(new int[][] {
                {1, 2},
                {3, 4}
        });

        int result = (Integer) evenNumbers.iterator().next();
        assertThat(result, is(2));

        result = (Integer) evenNumbers.iterator().next();
        assertThat(result, is(4));
    }
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        EvenNumbers evenNumbers = new EvenNumbers(new int[][] {
                {1, 2},
                {3, 4, 5, 7}
        });

        evenNumbers.iterator().next();
        evenNumbers.iterator().next();

        boolean result = evenNumbers.iterator().hasNext();

        assertThat(result, is(false));
    }

}
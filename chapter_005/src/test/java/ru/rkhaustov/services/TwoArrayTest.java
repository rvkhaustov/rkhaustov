package ru.rkhaustov.services;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class TwoArrayTest {
    /**
     * Test next().
     */
    @Test
    public void whenNextThenPointerForward() {
        TwoArray twoArray = new TwoArray(new int[][] {
                {1, 2},
                {3, 4}
        });

        int result = (Integer) twoArray.iterator().next();
        assertThat(result, is(1));

        result = (Integer) twoArray.iterator().next();
        assertThat(result, is(2));
        twoArray.iterator().hasNext();

        result = (Integer) twoArray.iterator().next();
        assertThat(result, is(3));
        twoArray.iterator().hasNext();

        result = (Integer) twoArray.iterator().next();
        assertThat(result, is(4));
    }
    /**
     * Test hasNext().
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        TwoArray twoArray = new TwoArray(new int[][] {
                {1},
                {3}
        });

        twoArray.iterator().next();
        twoArray.iterator().next();

        boolean result = twoArray.iterator().hasNext();

        assertThat(result, is(false));
    }


}
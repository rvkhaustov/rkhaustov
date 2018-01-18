package ru.rkhaustov.testtask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 01.12.2017.
 */
public class PlayersTest {

    /**
     * whenRandomTo3ThenOutput0or1or3.
     */
    @Test
    public void whenRandomTo3ThenOutput0or1or3() {
        boolean result = true;
        boolean expected = true;

        for (int index = 0; index < 10000; index++) {
            int i = Players.random(1, 2);

            if (i < 0 && i > 2) {
                result = false;
                break;
            }
        }

        assertThat(result, is(expected));

    }
}
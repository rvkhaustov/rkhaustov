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
        boolean result;
        boolean expected = true;

        result = Players.random(3) < 3 ? true : false;
        assertThat(result, is(expected));

        result = Players.random(3) < 3 ? true : false;
        assertThat(result, is(expected));

        result = Players.random(3) < 3 ? true : false;
        assertThat(result, is(expected));

        result = Players.random(3) < 3 ? true : false;
        assertThat(result, is(expected));

    }
}
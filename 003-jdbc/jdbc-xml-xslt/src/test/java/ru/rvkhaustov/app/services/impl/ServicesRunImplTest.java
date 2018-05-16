package ru.rvkhaustov.app.services.impl;

import org.junit.Test;
import ru.rvkhaustov.app.services.ServicesRun;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.is;

/**
 * Created by rvkha_000 on 27.04.2018.
 */
public class ServicesRunImplTest {
    /**
     * execute.
     */
    @Test
    public void execute() {
        ServicesRun servicesRun = new ServicesRunImpl();
        servicesRun.setCount(1000000L);
        servicesRun.setDatabase("C:/other/Install/sqLite/test.sqlite");
        long result = servicesRun.execute();
        long expected = 499999500000L;
        assertThat(expected, is(result));
    }
}
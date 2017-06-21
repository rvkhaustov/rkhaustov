package ru.rkhaustov.threadpool;

import org.junit.Test;

//import static org.junit.Assert.*;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class ThreadPoolTest {
    /**
     * Test Thread pool.
     */
    @Test
    public void whenAdd200ThreadThanThreadPoolProcesses() {
        ThreadPool threadPool = new ThreadPool();

        for (int work = 0; work < 100; work++) {
            threadPool.add(new WorkRand());
            threadPool.add(new WorkPrint());
        }
    }

}
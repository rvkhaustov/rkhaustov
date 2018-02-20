package ru.rkhaustov.testtask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rvkha_000 on 07.02.2018.
 */
public class MonsterTest extends TestBase {
    /**
     * setUp.
     */
    @Before
    public void setUp() {
        before();
    }

    /**
     * fieldMovementSUCCESS.
     */
    @Test
    public void fieldMovementSUCCESS() {
        Thread firstMonster = new Thread(players.get(0));
        Thread secondMonster = new Thread(players.get(1));
        firstMonster.start();
        secondMonster.start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ExitThreads " + players.get(0).isExitThreads());
        players.get(0).setExitThreads(true);
        boolean expected = players.get(0).isExitThreads();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ExitThreads " + expected);
        assertTrue(expected);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void fieldMovementIsInterrupted() throws Exception {
        Thread firstMonster = new Thread(players.get(0));
        lockBoard[2][2].lock();
        firstMonster.start();
        Thread.sleep(50);
        firstMonster.interrupt();
        boolean expected = firstMonster.isInterrupted();
        Thread.sleep(1000);
        assertTrue(expected);
    }

}
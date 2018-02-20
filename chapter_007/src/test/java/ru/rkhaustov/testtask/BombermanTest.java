package ru.rkhaustov.testtask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * Created by rvkha_000 on 07.02.2018.
 */
public class BombermanTest extends TestBase {

    /**
     * @throws Exception Exception
     */
    @Before
    public void setUp() throws Exception {
        before();
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void fieldMovement() throws Exception {
        Thread firstMonster = new Thread(players.get(0));
        Thread secondMonster = new Thread(players.get(1));
        Thread bomberman = new Thread(players.get(2));
        firstMonster.start();
        secondMonster.start();
        bomberman.start();
        Thread.sleep(600);
        players.get(2).newCell(0, 1);
        Thread.sleep(600);
        players.get(2).newCell(1, 0);
        Thread.sleep(600);
        players.get(2).newCell(2, 1);
        Thread.sleep(600);
        players.stream().forEach(player -> player.setExitThreads(true));
        Thread.sleep(1000);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void newCellWhenCellLargeMaxThenPrevValue() throws Exception {
        Thread bomberman = new Thread(players.get(2));
        bomberman.start();
        Thread.sleep(600);
        boolean result = players.get(2).newCell(5, 5);
        assertFalse(result);
    }

    /**
     * @throws Exception Exception
     */
    @Test
    public void fieldMovementIsInterrupted() throws Exception {
        Thread bomberman = new Thread(players.get(2));
        bomberman.start();
        Thread.sleep(100);
        players.get(2).newCell(0, 1);
        Thread.sleep(100);
        bomberman.interrupt();
        boolean expected = bomberman.isInterrupted();
        Thread.sleep(1000);
        assertTrue(expected);
    }
}
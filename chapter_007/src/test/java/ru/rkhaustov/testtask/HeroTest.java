package ru.rkhaustov.testtask;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rvkha_000 on 26.11.2017.
 */
public class HeroTest {
    /**
     * X.
     */
    private static final int X = 10;
    /**
     * Y.
     */
    private static final int Y = 20;
    /**
     * lockBoard.
     */
    private ReentrantLock[][] lockBoard = new ReentrantLock[X][Y];
    /**
     * stopThread.
     */
    private boolean stopThread;

    /**
     * x.
     */
    private int x;

    /**
     * y.
     */
    private int y;

    /**
     * result.
     */
    private boolean result;

    /**
     * playerFirst.
     */
    private Players playerFirst;

    /**
     * befor.
     */
    @Before
    public void before() {

        Hero.setMaxXY(X, Y);

        this.x = 2;
        this.y = 2;

        this.result = true;

        this.playerFirst = new Hero(lockBoard, this.x, this.y, "playerFirst");

        stopThread = false;

        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                lockBoard[x][y] = new ReentrantLock();
            }
        }
    }

    /**
     * whenLockCellsBlockCellThenFalse.
     */
    @Test
    public void whenLockCellsBlockCellThenFalse() {

        Thread threadPlayerFirst = new Thread((new Runnable() {
            @Override
            public void run() {

                System.out.println("playerFirst.fieldMovement()" + playerFirst.fieldMovement());

            }
        }));

        threadPlayerFirst.start();

        if (threadPlayerFirst.isAlive()) {
            try {

                Thread.sleep(100);

                System.out.println(String.format("Main thread trylock, cell x = %s y = %s. Time - %s", this.x, this.y, System.currentTimeMillis()));
                this.result = lockBoard[2][2].tryLock();
                System.out.println(String.format("Main thread, cell x = %s y = %s lock - %s. Time - %s", this.x, this.y, !this.result ? "Yes" : "No", System.currentTimeMillis()));

                stopThread = true;
                playerFirst.setExitThreads(stopThread);
                threadPlayerFirst.interrupt();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }

        assertFalse(this.result);

    }

    /**
     * whenLockCellsNoBlockCellThenTrue.
     */
    @Test
    public void whenLockCellsNoBlockCellThenTrue() {

        Thread threadPlayerFirst = new Thread((new Runnable() {
            @Override
            public void run() {

                System.out.println("playerFirst.fieldMovement()" + playerFirst.fieldMovement());

            }
        }));

        threadPlayerFirst.start();

        if (threadPlayerFirst.isAlive()) {
            try {

                Thread.sleep(100);
                System.out.println(String.format("Main thread trylock cell x = %s y = %s", x, y));
                result = lockBoard[2][3].tryLock();

                System.out.println(String.format("Cell x = %s y = %s lock - %s", x, y, !result ? "Yes" : "No"));
                stopThread = true;
                playerFirst.setExitThreads(stopThread);
                threadPlayerFirst.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertTrue(result);

    }

    /**
     * whenEmulationOfTheGame.
     */
    @Test
    public void whenEmulationOfTheGame() {

        int xSecond = 1;
        int ySecond = 2;
        Hero.setMaxXY(2, 2);

        final int threadCount = 2;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);

        final Players playerSecond = new Hero(this.lockBoard, xSecond, ySecond, "playerSecond");

        service.execute(this.playerFirst);
        service.execute(playerSecond);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        playerFirst.setExitThreads(true);
        playerSecond.setExitThreads(true);

        System.out.println("stop true");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

}
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
    static final int X = 10;
    /**
     * Y.
     */
    static final int Y = 20;
    /**
     * lockBoard.
     */
    private ReentrantLock[][] lockBoard = new ReentrantLock[X][Y];
    /**
     * stopThread.
     */
    private boolean stopThread;

    /**
     * befor.
     */
    @Before
    public void befor() {
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

        Cell cellFirst = new Cell(2, 2, 10, 10);
        boolean result = true;
        Players playerFirst = new Hero(lockBoard, cellFirst, "playerFirst");

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
                System.out.println(String.format("Main поток пытается заблокировать %s", cellFirst));
                result = lockBoard[2][2].tryLock();

                System.out.println(String.format("%s заблокировано %s", cellFirst, !result ? "Да" : "Нет"));
                stopThread = true;
                playerFirst.setExitThreads(stopThread);
                threadPlayerFirst.interrupt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertFalse(result);

    }

    /**
     * whenLockCellsNoBlockCellThenTrue.
     */
    @Test
    public void whenLockCellsNoBlockCellThenTrue() {

        Cell cellFirst = new Cell(2, 2, 10, 10);
        boolean result = true;
        Players playerFirst = new Hero(lockBoard, cellFirst, "playerFirst");

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
                System.out.println(String.format("Main поток пытается заблокировать %s", cellFirst));
                result = lockBoard[2][3].tryLock();

                System.out.println(String.format("%s заблокировано %s", cellFirst, !result ? "Да" : "Нет"));
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

        Cell cellFirst = new Cell(2, 2, 3, 3);
        Cell cellSecond = new Cell(3, 3, 3, 3);
        final int threadCount = 2;
        final ExecutorService service = Executors.newFixedThreadPool(threadCount);
        final Players playerFirst = new Hero(this.lockBoard, cellFirst, "playerFirst");
        final Players playerSecond = new Hero(this.lockBoard, cellSecond, "playerSecond");

        service.execute(playerFirst);
        service.execute(playerSecond);

        try {
            Thread.sleep(10000);
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
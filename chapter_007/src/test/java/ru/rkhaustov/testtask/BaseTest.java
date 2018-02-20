package ru.rkhaustov.testtask;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by rvkha_000 on 26.11.2017.
 */
public class BaseTest extends TestBase {

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        before();
    }


    /**
     * whenRandomTo3ThenOutput0or1or3.
     */
    @Test
    public void whenRandomTo3ThenOutput0or1or3() {
        boolean result = true;
        boolean expected = true;

        for (int index = 0; index < 10000; index++) {
            int i = Base.random(1, 2);

            if (i < 0 && i > 2) {
                result = false;
                break;
            }
        }

        assertThat(result, is(expected));

    }

    /**
     * whenLockCellsTryBlockCellNoWaitThenTrue.
     */
    @Test
    public void whenLockCellsTryBlockCellNoWaitThenFalse() {
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Base.lockCells(lockBoard[2][2], "First thread", 100, 10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    result = Base.lockCells(lockBoard[2][2], "Second thread", 100, 100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        firstThread.start();
        try {
            firstThread.join(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstThread.interrupt();
        secondThread.interrupt();
        assertFalse(this.result);
    }

    /**
     * whenLockCellsBlockCellThenFalse.
     */
    @Test
    public void whenLockCellsTryBlockCellWaitThenTrue() {

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Base.lockCells(lockBoard[2][2], "First thread", 100, 1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    result = Base.lockCells(lockBoard[2][2], "Second thread", 2000, 100);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });
        firstThread.start();
        try {
            firstThread.join(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondThread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstThread.interrupt();
        secondThread.interrupt();
        assertTrue(this.result);
    }
}
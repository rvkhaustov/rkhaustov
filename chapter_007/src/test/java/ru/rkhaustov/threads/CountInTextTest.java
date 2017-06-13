package ru.rkhaustov.threads;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by rvkha_000 on 13.06.2017.
 */
public class CountInTextTest {
    /**
     * Test method countWord.
     */
    @Test
    public void whencountWordThen16() {
        String separator = System.getProperty("line.separator");
        String text = "Mares eat oats" + separator
                + "Does eat oats" + separator
                + "Little lambs eat ivy" + separator
                + "A kid will eat ivy too";
        CountInText countInText = new CountInText(text);

        assertThat(countInText.countWord(), is(16));

    }

    /**
     * Test method countSpace.
     */
    @Test
    public void whenCountSpaceThen14() {
        String separator = System.getProperty("line.separator");
        String text = "Mares eat oats" + separator
                + "Does eat oats" + separator
                + "Little lambs  eat ivy" + separator
                + "A kid will eat  ivy too";
        CountInText countInText = new CountInText(text);
        assertThat(countInText.countSpace(), is(14));

    }
    /**
     * printAsynchOperations.
     */
    @Test
    public void printAsynchOperations() {
        String separator = System.getProperty("line.separator");
        String text = "Mares eat oats" + separator
                + "Does eat oats" + separator
                + "Little lambs eat ivy" + separator
                + "A kid will eat ivy too";

        System.out.println("Space start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Count space: %s", new CountInText(text).countSpace()));
            }
        }).start();

        System.out.println("Word  start");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Count word: %s", new CountInText(text).countWord()));
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**
     * print Asynch Operations Waiting for output.
     */
    @Test
    public void printAsynchOperationsThenWaitingForOutput() {
        String separator = System.getProperty("line.separator");
        String text = "Mares eat oats" + separator
                + "Does eat oats" + separator
                + "Little lambs eat ivy" + separator
                + "A kid will eat ivy too";

        System.out.println("Count Space start");
        CountInText countInText = new CountInText(text);
        long startTime = System.currentTimeMillis();
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (countInText) {
                    System.out.println(String.format("Count space: %s", countInText.countSpace()));
                }
            }
        });
        firstThread.start();
        while (firstThread.isAlive()) {
            try {
                firstThread.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - startTime > 1000 && firstThread.isAlive()) {
                firstThread.interrupt();
            }
        }
        System.out.println("Count Space finish");

        System.out.println("Count Word  start");
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(String.format("Count word: %s", new CountInText(text).countWord()));
            }
        });
        secondThread.start();
        while (secondThread.isAlive()) {
            try {
                firstThread.join(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - startTime > 1000 && firstThread.isAlive()) {
                secondThread.interrupt();
            }
        }
        System.out.println("Count Word finish");
    }

    /**
     * print Asynch Operations program thread stop.
     */
    @Test
    public void printAsynchOperationsThenProgramThreadStop() {
        String separator = System.getProperty("line.separator");
        String text = "Mares eat oats" + separator
                + "Does eat oats" + separator
                + "Little lambs eat ivy" + separator
                + "A kid will eat ivy too";

        System.out.println("Count Space start");
        CountInText countInText = new CountInText(text);
        long startTime = System.currentTimeMillis();
        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (countInText) {
                    System.out.println(String.format("Count space: %s", countInText.countSpace()));
                }
            }
        });
        firstThread.start();
        while (firstThread.isAlive()) {
            try {
                firstThread.join(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (System.currentTimeMillis() - startTime > 6 && firstThread.isAlive()) {
                countInText.setStopThreads(false);
            }
        }
        System.out.println("Count Space finish");
    }
}
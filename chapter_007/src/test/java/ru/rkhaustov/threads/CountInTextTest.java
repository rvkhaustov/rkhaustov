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
}
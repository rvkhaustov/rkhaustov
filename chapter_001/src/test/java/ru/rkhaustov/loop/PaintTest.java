package ru.rkhaustov.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* @author rkvhaustov
* @version 1.0
* @since 04.2017
*/
public class PaintTest {
   /**
   * Test Max.
   */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
/**
   * Test Max.
   */
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
       //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
           Paint paint = new Paint();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
}

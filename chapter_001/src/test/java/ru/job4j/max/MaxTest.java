package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Roman Khaustov
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
  /**
   * Test Max.
   */
   @Test
    public void whenMaxThreeTwoThenThree() {
    Max maxValue = new Max();
    int result = maxValue.max(3, 2);
    int expected =  3;
    assertThat(result, is(expected));
    }
    /**
    * Test Max on three variable.
     */
    @Test
    public void whenMaxFiveThreeTwoThenFive() {
        Max maxValue = new Max();
        int result = maxValue.max(5, 3, 2);
        int expected = 5;
        assertThat(result, is(expected));
    }
}
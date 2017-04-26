package ru.rkhaustov.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
  *
  * @author rkhaustov
  * @version 1
  * @since 04.2017
  */
public class PointTest {
/**
 * Test Point true.
 */
 @Test
 public void whenIsTrueThenTrue() {
 Point point = new Point(1, 5);
 boolean result = point.is(2, 3);
 boolean expected = true;
 assertThat(result, is(expected));
 }
/**
 * Test Point false.
 */
 @Test
 public void whenIsFalseThenFulse() {
 Point point = new Point(2, 5);
 boolean result = point.is(2, 3);
 boolean expected = false;
 assertThat(result, is(expected));
 }

}
package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
  *
  * @author rkhaustov
  * @version 1
  * @since 04.2017
  */
public class TriangleTest {
/**
 * Test Calculater area true.
 */
 @Test
 public void whenAreaThenMayConstructTriangle() {
 Point a = new Point(0, 0);
 Point b = new Point(0, 1);
 Point c = new Point(1, 0);

 Triangle triangle = new Triangle(a, b, c);
 double result = triangle.area();
 double  expected = 0.5;
 assertThat(result, closeTo(expected, 0.01));
 }

/**
 * Test Calculater area false.
 */
 @Test
 public void whenAreaImpossibleThenConstructTriangle() {
 Point a = new Point(0, 0);
 Point b = new Point(0, 1);
 Point c = new Point(0, 2);

 Triangle triangle = new Triangle(a, b, c);
 double result = triangle.area();
 double  expected = 0.0;
 assertThat(result, closeTo(expected, 0.01));
 }

/**
 * Test lengthSide.
 */
 @Test
 public void whenLengthSideThenTree() {
 Point a = new Point(3, 0);
 Point b = new Point(0, 1);
 Point c = new Point(0, 2);
 Triangle triangle = new Triangle(a, b, c);
 double result = triangle.lengthSide(a, b);
 double  expected = 3.16;
 assertThat(result, closeTo(expected, 0.01));
 }
/**
 * Test validate true.
 */
 @Test
 public void whenValidateThenMayConstructTriangleTrue() {
 Point a = new Point(0, 0);
 Point b = new Point(0, 1);
 Point c = new Point(1, 0);

 Triangle triangle = new Triangle(a, b, c);
 boolean result = triangle.validate();
 boolean  expected = true;
 assertThat(result, is(expected));
 }
/**
 * Test validate false.
 */
 @Test
 public void whenValidateThenImpossibleConstructTriangleFalse() {
 Point a = new Point(0, 0);
 Point b = new Point(0, 1);
 Point c = new Point(0, 2);

 Triangle triangle = new Triangle(a, b, c);
 boolean result = triangle.validate();
 boolean  expected = false;
 assertThat(result, is(expected));
 }

}
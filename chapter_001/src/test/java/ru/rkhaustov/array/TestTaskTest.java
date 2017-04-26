package ru.rkhaustov.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* @author rkhaustov
* @version 1.0
* @since 04.2017
*/
public class TestTaskTest {
   /**
   * Test contains.
   */
    @Test
    public void whenContainsSubInOriginThanTrue() {
    TestTask testTask = new TestTask();
   // String origin = "MySQL";
    String origin = "Building a Web UI for MySQL Databases in Plain Java";
    String sub = "MySQL";
    boolean result = testTask.contains(origin, sub);
    boolean expected = true;
    assertThat(result, is(expected));
    }
   /**
   * Test contains.
   */
    @Test
    public void whenContainsSubNotInOriginThanFalse() {
    TestTask testTask = new TestTask();
    String origin = "Building a Web UI for MySQL Databases in Plain Java";
    String sub = "Terradata";
    boolean result = testTask.contains(origin, sub);
    boolean expected = false;
    assertThat(result, is(expected));
    }
      /**
   * Test contains.
   */
    @Test
    public void whenContainsSubLargeOriginThanFalse() {
    TestTask testTask = new TestTask();
   // String origin = "MySQL";
    String origin = "MySQL";
    String sub = "MySQL ";
    boolean result = testTask.contains(origin, sub);
    boolean expected = false;
    assertThat(result, is(expected));
    }
}
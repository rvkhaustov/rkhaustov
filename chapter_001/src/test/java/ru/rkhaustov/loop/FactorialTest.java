package ru.rkhaustov.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author rkhaustov
 * @version 1
 * @since 04.2017
 */
public class FactorialTest {
    /**
   * Test calc.
   */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
      Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
    }
    /**
   * Test calc.
   */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
             //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
    }
}
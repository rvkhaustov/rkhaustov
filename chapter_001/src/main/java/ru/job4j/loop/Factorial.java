package ru.job4j.loop;
/**
 * @author rkhaustov
 * @version 1
 * @since 04.2017
 */
public class Factorial {
  /**
  * Calc.
  * @param n - n
  * @return result
  */
    public int calc(int n) {
     int value = 1;
        for (int index = 1; index <= n; index++) {
            value *= index;
        }
        return value;
    }
}
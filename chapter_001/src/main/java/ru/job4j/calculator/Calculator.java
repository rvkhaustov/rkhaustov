package ru.job4j.calculator;
/**
 * Calculator.
 *
 * @author Roman Khaustov (romavsb@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Calculator {
  /**
  * @param result - result.
  */
  private double result;
  /**
  * Add.
  * @param first - first.
  * @param second - second.
  */
   public void add(double first, double second) {
   this.result = first + second;
  }
  /**
  * Subtraction.
  * @param first - first.
  * @param second - second.
  */
  public void subtraction(double first, double second) {
   this.result = first - second;
  }
  /**
  * divide.
  * @param first - first.
  * @param second - second.
  */
  public void divide(double first, double second) {
   this.result = first / second;
  }
  /**
  * multyply.
  * @param first - first.
  * @param second - second.
  */
  public void multyply(double first, double second) {
   this.result = first * second;
  }
  /**
  * getResult.
  * @return  result - result.
  */
  public double getResult() {
  return this.result;
  }
}
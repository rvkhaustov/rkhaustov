package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* CalculatorTest.
*
* @author Roman Khaustov (mailto:romavsb@gmail.com)
* @version $Id$
* @since 0.1
*/
public class CalculatorTest {
/**
* Test add.
*/
 @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
/**
* Test subtraction.
*/
 @Test
    public void whenSubtractionOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.subtraction(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
/**
* divide add.
*/
 @Test
    public void whendivideOneDivOneThenOne() {
        Calculator calc = new Calculator();
        calc.divide(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
   /**
    * multyply add.
    */
    @Test
    public void whenMultyplyOneMulTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.multyply(1D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
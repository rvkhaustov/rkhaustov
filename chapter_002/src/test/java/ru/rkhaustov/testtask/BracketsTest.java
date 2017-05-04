package ru.rkhaustov.testtask;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * Created by rvkha_000 on 04.05.2017.
 */
public class BracketsTest {
    /**
     * test "()()".
     */
    @Test
    public void whenBracketsFirstThenTrue() {
        Brackets brackets = new Brackets();
        boolean result = brackets.checkBrackets("()()");
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * test item ))((.
     */
    @Test
    public void whenBracketsSecondThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.checkBrackets("))((");
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * test item ())(.
     */
    @Test
    public void whenBracketsThirdThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.checkBrackets("())(");
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * test item ())()(().
     */
    @Test
    public void whenBracketsFourthThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.checkBrackets("())()(()");
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     * test item (((((((())()(())).
     */
    @Test
    public void whenBracketsFiveThenFalse() {
        Brackets brackets = new Brackets();
        boolean result = brackets.checkBrackets("(((((((())()(()))");
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
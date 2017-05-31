package ru.rkhaustov.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 31.05.2017.
 */
public class CycleTest {
    /**
     * Method hasCycle, Contains a closure.
     */
    @Test
    public void whenCycleContainsClosureThenTrue() {
        Cycle<Integer> cycle = new Cycle<>();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(first);

        boolean result = cycle.hasCycle(first);
        assertThat(result, is(true));

    }
    /**
     * Method hasCycle, no Contains a closure.
     */
    @Test
    public void whenCycleNoContainsClosureThenFalse() {
        Cycle<Integer> cycle = new Cycle<>();
        Node first = new Node(1);
        Node two = new Node(2);
        Node third = new Node(3);
        Node four = new Node(4);

        first.setNext(two);
        two.setNext(third);
        third.setNext(four);
        four.setNext(null);

        boolean result = cycle.hasCycle(first);
        assertThat(result, is(false));

    }

}
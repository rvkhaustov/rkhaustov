package ru.rkhaustov.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by rvkha_000 on 31.05.2017.
 */
public class SetArrayTest {
    /**
     * Method Add.
     */
    @Test
    public void whenAddFourObjectsThenThreeObjects() {
        SetArray<Integer> array = new SetArray<>(0);
        array.add(4);
        array.add(1);
        array.add(4);
        array.add(2);

        assertThat(array.getObjects()[0], is(4));
        assertThat(array.getObjects()[2], is(2));
        assertThat(array.getObjects()[1], is(1));

    }
    /**
     * test method next() Iterator <Integer>.
     */
    @Test
    public void whenNextThenPointerForward() {
        SetArray<Integer> list = new SetArray<>(0);

        list.add(4);
        list.add(3);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(1);

        Iterator<Integer> iterator = list.iterator();

        int result = iterator.next();
        assertThat(result, is(4));

        result = iterator.next();
        assertThat(result, is(3));

        result = iterator.next();
        assertThat(result, is(2));

        result = iterator.next();
        assertThat(result, is(1));
    }
    /**
     * Test hasNext() Iterator <Float>.
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        SetArray<Float> list = new SetArray<>(100);

        list.add(4f);
        list.add(3f);
        list.add(3f);


        Iterator<Float> iterator = list.iterator();

        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();

        assertThat(result, is(false));
    }

}
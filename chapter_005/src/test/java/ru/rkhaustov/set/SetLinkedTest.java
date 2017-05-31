package ru.rkhaustov.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 31.05.2017.
 */
public class SetLinkedTest {
    /**
     * test method add and Iterator <String>.
     */
    @Test
    public void  whenAddAndIteratorThenTrue() {
        SimpleSet<String> list = new SetLinked<>();

        list.add("test0");
        list.add("test1");
        list.add("test0");
        //      String result = list.;
        Iterator<String> iterator = list.iterator();

        String result = iterator.next();
        assertThat(result, is("test0"));

        result = iterator.next();
        assertThat(result, is("test1"));

        boolean resultHas = iterator.hasNext();
        assertThat(resultHas, is(false));


    }

    /**
     * Test hasNext() Iterator <Float>.
     */
    @Test
    public void whenHasNextCheckNextThenReturnFalse() {
        SimpleSet<Float> list = new SetLinked<>();

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
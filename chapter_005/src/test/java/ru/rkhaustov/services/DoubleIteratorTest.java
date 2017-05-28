package ru.rkhaustov.services;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 27.05.2017.
 */
public class DoubleIteratorTest {
    /**
     * Convert Iterator of iterator.
     */
    @Test
    public void whenConvertInOwnIneratorfromFourIteratoraThenTrue() {
        InterfaceConvert implementsConvert = new ImplementsConvert();
        Iterator<Iterator<Integer>> iterator = Arrays.asList(
                Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator(),
                new ArrayList<Integer>().iterator(),
                Arrays.asList(0, 9, 8, 7, 5).iterator(),
                Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator()).iterator();
        Iterator<Integer> result = implementsConvert.convert(iterator);
        int[] expected =  {4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        int index = 0;
        while (result.hasNext()) {
            assertThat(result.next(), is(expected[index++]));
        }
    }
}
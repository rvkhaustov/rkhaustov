package ru.rkhaustov.services;

import java.util.Iterator;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class ImplementsConvert implements InterfaceConvert {
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new DoubleIterator(it);
    }
}

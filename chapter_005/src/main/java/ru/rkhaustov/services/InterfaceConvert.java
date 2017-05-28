package ru.rkhaustov.services;

import java.util.Iterator;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public interface InterfaceConvert {
    /**
     * @param it iterator
     * @return Iterator Integer
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);
}

package ru.rkhaustov.services;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class DoubleIterator implements Iterator {

    /**
     * iteratorAll.
     */
    private final Iterator<Iterator<Integer>> iteratorAll;

    /**
     * currentIterator.
     */
    private Iterator<Integer> innerIterator = null;

    /**
     * @param iteratorAll iteratorAll
     */
    public DoubleIterator(Iterator<Iterator<Integer>> iteratorAll) {
        this.iteratorAll = iteratorAll;
        this.innerIterator = this.iteratorAll.hasNext() ? this.iteratorAll.next() : null;
    }

    /**
     * @return hasNext
     */
    @Override
    public boolean hasNext() {
        if (!innerIterator.hasNext() && iteratorAll.hasNext()) {
             do {
                innerIterator = iteratorAll.next();
            } while (!innerIterator.hasNext() && iteratorAll.hasNext());
        }
        return (innerIterator != null && innerIterator.hasNext());
    }

    /**
     * @return next
     */
    @Override
    public Object next() {
        if (!innerIterator.hasNext() && iteratorAll.hasNext()) {
            do {
                innerIterator = iteratorAll.next();
            } while (!innerIterator.hasNext() && iteratorAll.hasNext());
        }

        if (innerIterator == null) {
            throw new NoSuchElementException();
        }
        return innerIterator.next();
    }
}

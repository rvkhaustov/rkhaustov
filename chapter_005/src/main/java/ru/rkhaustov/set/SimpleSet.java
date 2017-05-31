package ru.rkhaustov.set;

/**
 * Created by rvkha_000 on 30.05.2017.
 * @param <E> generic
 */
public interface SimpleSet<E> extends Iterable {
    /**
     * @param e value object.
     */
    void add(E e);
}

package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 30.05.2017.
 * @param <E> type object.
 */

public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * @param e value objects.
     */
    void add(E e);
    /**
     * @param index position number.
     * @return value object.
     */
    E get(int index);
}

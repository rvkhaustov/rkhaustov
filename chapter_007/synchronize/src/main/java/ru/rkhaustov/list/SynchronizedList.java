package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 17.06.2017.
 * @param <E> type object.
 */

public interface SynchronizedList<E> extends Iterable<E> {
    /**
     * @param e e value objects.
     * @return current index position
     */
    int add(E e);
    /**
     * @param index position number.
     * @return value object.
     */
    E get(int index);

    /**
     * @return size arrays.
     */
    int size();
}
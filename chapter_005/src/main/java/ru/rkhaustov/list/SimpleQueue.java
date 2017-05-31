package ru.rkhaustov.list;


/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <E> type object.
 */
public interface SimpleQueue<E> {
    /**
     * Method Pop FIFO or LIFO.
     * @return first object.
     */
   E pop();
    /**
     * @param e add object.
     */
   void push(E e);
}

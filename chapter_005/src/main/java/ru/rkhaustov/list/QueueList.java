package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <E> type object.
 */
public class QueueList<E> implements SimpleQueue<E>  {
    /**
     * linkedArray from LinkedArray.
     */
    private LinkedArray<E> linkedArray = new LinkedArray<>();
    /**
     * size list.
     */
    private int size = 0;

    /**
     * Method Pop FIFO.
     * @return first object.
     */
    @Override
    public E pop() {
        if (size != 0) {
            E object = linkedArray.get(0);
            linkedArray.removeFirst();
            size--;
            return object;
        }
        return null;
    }

    /**
     * @return get linkedArray
     */
    public LinkedArray<E> getLinkedArray() {
        return linkedArray;
    }

    /**
     * @param e add object.
     */
    @Override
    public void push(E e) {
        linkedArray.add(e);
        size++;
    }
}

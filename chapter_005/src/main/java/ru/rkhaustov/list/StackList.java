package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <E> type object.
 */
public class StackList<E> implements SimpleQueue<E>  {
    /**
     * linkedArray from LinkedArray.
     */
    private LinkedArray<E> linkedArray = new LinkedArray<>();
    /**
     * size list.
     */
    private int size = 0;

    /**
     * Method Pop LIFO.
     * @return first object.
     */
    @Override
    public E pop() {
        if (size != 0) {
            E object = linkedArray.get(size - 1);
            linkedArray.removeLast();
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


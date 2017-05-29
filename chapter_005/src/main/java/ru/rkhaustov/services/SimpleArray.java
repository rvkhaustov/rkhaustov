package ru.rkhaustov.services;

import java.util.Arrays;

/**
 * @param <E> generic.
 */
public class SimpleArray<E> {
    /**
     * object.
     */
    private Object[] object;
    /**
     * position.
     */
    private int position = 0;

    /**
     * @return string.
     */
    @Override
    public String toString() {
        return Arrays.toString(object);
    }

    /**
     * @param size size array.
     */
    public SimpleArray(int size) {
        this.object = new Object[size];
    }

    /**
     * @param value add value
     */
    public void add(E value) {
        if (position >= object.length) {
            object = Arrays.copyOf(object, (int) (1.5 * position) + 1);
        }
        this.object[position++] = value;
    }

    /**
     * @param index index
     * @return get object
     */
    public E get(int index) {
        return (E) this.object[index];
    }

    /**
     * @param value value
     * @param index index
     */
    public void update(E value, int index) {
        this.object[index] = value;
    }

    /**
     * @param  index index.
     */
    public void delete(int index) {
        Object[] objects = Arrays.copyOf(object, position - 1);
        System.arraycopy(object, index + 1, objects, index, position - index - 1);
        object = objects;
        position--;
    }
}

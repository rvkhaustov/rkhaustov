package ru.rkhaustov.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by rvkha_000 on 30.05.2017.
 * @param <E> generic
 */
public class DynamicList<E> implements SimpleContainer<E> {
    /**
     * objects[].
     */
    private Object[] objects;
    /**
     * currentIndex.
     */
    private int currentIndex = 0;

    /**
     * Construction on size.
     * @param size size array
     */
    public DynamicList(int size) {
        this.objects = new Object[size];
    }

    /**
     * Construction on objects.
     * @param objects object.
     */
    public DynamicList(Object[] objects) {
        this.objects = objects;
    }

    /**
     * Method add.
     * @param e value object.
     */
    @Override
    public void add(E e) {
        if (currentIndex >= objects.length) {
            objects = Arrays.copyOf(objects, (int) (1.5 * currentIndex) + 1);
        }
        this.objects[currentIndex++] = e;
    }

    /**
     * Method get.
     * @param index number position.
     * @return value object.
     */
    @Override
    public E get(int index) {
        return index >= 0 && index < objects.length ? (E) objects[index] : null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DynamicListIterator();
    }

    /**
     * implements Iterator methods.
     */
    class DynamicListIterator implements Iterator<E> {
        /**
         * indexIterator.
         */
        private int indexIterator = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return indexIterator < objects.length ? true : false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) objects[indexIterator++];

        }
    }
}

package ru.rkhaustov.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 17.06.2017.
 * @param <E> generic
 */
public class DynamicListSynch<E> implements SynchronizedList<E> {
    /**
     * objects[].
     */
    private volatile Object[] objects;
    /**
     * currentIndex.
     */
    private int currentIndex = 0;

    /**
     * Construction on capacity.
     * @param capacity capacity array
     */
    public DynamicListSynch(int capacity) {
        this.objects = new Object[capacity];
    }

    /**
     * Construction on objects.
     * @param objects object.
     */
    public DynamicListSynch(Object[] objects) {
        this.objects = objects;
    }

    /**
     * Method add.
     * @param e e value objects.
     * @return current index position
     */
    @Override
    public int add(E e) {
        synchronized (objects) {
            if (currentIndex >= objects.length) {
                objects = Arrays.copyOf(objects, (int) (1.5 * currentIndex) + 1);
            }
            this.objects[currentIndex] = e;
            return currentIndex++;
        }
    }

    /**
     * Method get.
     * @param index number position.
     * @return value object.
     */
    @Override
    public E get(int index) {
        synchronized (objects) {
            return (index >= 0 && index < currentIndex) ? (E) objects[index] : null;
        }
    }

    /**
     * @return size arrays.
     */
    @Override
    public int size() {
        synchronized (objects) {
            return currentIndex;
        }
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
            return indexIterator < currentIndex ? true : false;
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
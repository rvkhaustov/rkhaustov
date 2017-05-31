package ru.rkhaustov.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <E> generic
 */
public class SetArray<E> implements SimpleSet<E> {
    /**
     * objects.
     */
    private Object[] objects;
    /**
     * currentIndex.
     */
    private int currentIndex = 0;

    /**
     * @return array objects.
     */
    public Object[] getObjects() {
        return objects;
    }

    /**
     * @param size size array.
     */
    public SetArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * @param e value object.
     */
    @Override
    public void add(E e) {
        for (int index = 0; index < currentIndex; index++) {
            if (e.equals(objects[index])) {
                return;
            }
        }
        if (currentIndex >= objects.length) {
            objects = Arrays.copyOf(objects, (int) (1.5 * currentIndex) + 1);
        }
        objects[currentIndex++] = e;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SetListIterator();
    }

    /**
     * implements Iterator methods.
     */
    class SetListIterator implements Iterator<E> {
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

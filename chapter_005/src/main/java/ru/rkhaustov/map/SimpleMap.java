package ru.rkhaustov.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 01.06.2017.
 * @param <T> key.
 * @param <V> value.
 */

public class SimpleMap<T, V> implements Iterable<V> {


    /**
     * data - catalog.
     */
    private Pair<T, V>[] data;
      /**
     * currentIndex.
     */
    private  int currentIndex = 0;
    /**
     * size.
     */
    private int size = 16;

    /**
     * @param size size array.
     */
    public SimpleMap(int size) {
        this.data = new Pair[size];
        this.size = size == 0 ? 1 : size;
    }

    /**
     * construction.
     */
    public SimpleMap() {
        this.data = new Pair[this.size];
    }

    /**
     * @param <T> T
     * @param <V> V
     */
    public class Pair<T, V> {
        /**
         * key.
         */
        private T objectT;
        /**
         * value.
         */
        private V objectV;

        /**
         * @return T
         */
        public T getObjectT() {
            return objectT;
        }

        /**
         * @param objectT T
         */
        public void setObjectT(T objectT) {
            this.objectT = objectT;
        }

        /**
         * @return V
         */
        public V getObjectV() {
            return objectV;
        }

        /**
         * @param objectV V
         */
        public void setObjectV(V objectV) {
            this.objectV = objectV;
        }

        /**
         * @param objectT T
         * @param objectV V
         */
        public Pair(T objectT, V objectV) {
            this.objectT = objectT;
            this.objectV = objectV;
        }
    }

    /**
     * @param key key
     * @param value value
     * @return true insert value, false Collision.
     */
    boolean insert(T key, V value) {

        resize();

        if (key == null) {
            if (this.data[0] == null) {
//            if (this.data[0].getObjectV() == null) {
                this.data[0] = new Pair<>(key, value);
                currentIndex++;
            }
            this.data[0].setObjectV(value);
            return true;
        }

        int index = indexFor(key, size);
        if (this.data[index] == null) {
            this.data[index] = new Pair<>(key, value);
            currentIndex++;
            return true;
        } else if (index == indexFor(this.data[index].getObjectT(), size)
                && this.data[index].getObjectT().equals(key)) {
            this.data[index].setObjectV(value);
            currentIndex++;
            return true;
        }
        return false;
    }

    /**
     * @param key key.
     * @return value.
     */
    V get(T key) {
        return  this.data[indexFor(key, size)] == null ? null : this.data[indexFor(key, size)].getObjectV();
    }

    /**
     * @param key key
     * @return correct delete
     */
    boolean delete(T key) {
        int indexFor = indexFor(key, size);
        if (this.data[indexFor].getObjectV() != null) {
            this.data[indexFor] = null;
            this.currentIndex--;
            return true;
        }
        return false;
    }

    /**
     * Resize array.
     */
    void resize() {
        if (currentIndex >= (int) (size * 0.75) || currentIndex == 0) {
            size *= 2;
            Pair<T, V>[] newPair = new Pair[this.size];
            int indexF = 0;
            for (int index = 0; index < this.data.length; index++) {
                if (this.data[index] != null) {
                    indexF = indexFor(this.data[index].getObjectT(), size);
                    if (newPair[indexF] == null) {
                        newPair[indexF] = new Pair<>(data[index].getObjectT(), data[index].getObjectV());

                    }
                }
            }
            this.data = newPair;
        }
    }

    /**
     * @param object object.
     * @param length size array.
     * @return index.
     */
    static int indexFor(Object object, int length) {
        return object != null ? object.hashCode() & (length - 1) : 0;
    }
    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new SimpleMapIterator();
    }

    /**
     * implements Iterator methods.
     */
    class SimpleMapIterator implements Iterator<V> {
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
            return nextObject() == -1 ? false : true;
        }

        /**
         * @return index
         */
        public int nextObject() {
            for (int index = indexIterator; index < size; index++) {
                if (data[index] != null) {
                    return index;
                }
            }
            return  -1;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public V next() {
            indexIterator = nextObject();
            if (indexIterator == -1) {
                throw new NoSuchElementException();
            }
            return  data[indexIterator++].getObjectV();

        }
    }
}

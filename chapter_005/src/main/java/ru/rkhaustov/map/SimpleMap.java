package ru.rkhaustov.map;

//import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 01.06.2017.
 * @param <T> key.
 * @param <V> value.
 */

public class SimpleMap<T, V> implements Iterable<V> {
    /**
     * key.
     */
    private Object[] objectT;
    /**
     * value.
     */
    private Object[] objectV;

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
        this.objectT = new Object[size];
        this.objectV = new Object[size];
    }

    /**
     * construction.
     */
    public SimpleMap() {
        this.objectT = new Object[this.size];
        this.objectV = new Object[this.size];
    }

    /**
     * @param key key
     * @param value value
     * @return true insert value, false Collision.
     */
    boolean insert(T key, V value) {
        if (key == null) {
            if (objectV[0] == null) {
                currentIndex++;
            }
            objectV[0] = value;
            return true;
        }
        if (currentIndex > (int) (size * 0.75)) {
            resize();
        }
        int index = indexFor(key.hashCode(), size);
        if (objectT[index] == null) {
            objectT[index] = key;
            objectV[index] = value;
            currentIndex++;
            return true;
        } else if (index == indexFor(objectT[index].hashCode(), size) && objectT[index].equals(key)) {
            objectV[index] = value;
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

        return (V) objectV[indexFor(key, size)];
    }

    /**
     * @param key key
     * @return correct delete
     */
    boolean delete(T key) {
        int indexFor = indexFor(key, size);
        if (objectV[indexFor] != null) {
            objectT[indexFor] = null;
            objectV[indexFor] = null;
            this.currentIndex--;
            return true;
        }
        return false;
    }

    /**
     * Resize array.
     */
    void resize() {
        size *= 2;
        Object[] objectsT = new Object[size];
        Object[] objectsV = new Object[size];
        int indexF = 0;

        for (int index = 0; index < objectT.length; index++) {
            if (objectV[index] != null) {
                indexF = indexFor(objectT[index], size);
                objectsT[indexF] = objectT[index];
                objectsV[indexF] = objectV[index];
            }
        }
        this.objectT = objectsT;
        this.objectV = objectsV;
    }

    /**
     * @param object oject.
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
                if (objectV[index] != null || objectT[index] != null) {
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
            return (V) objectV[indexIterator++];

        }
    }


//    /**
//     * @return string.
//     */
//    @Override
//    public String toString() {
//        return "SimpleMap{" +
//                "objectV=" + Arrays.toString(objectV) +
//                '}';
//    }
}

package ru.rkhaustov.list;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Created by rvkha_000 on 30.05.2017.
 * @param <E> type object.
 */
public class LinkedArray<E> implements SimpleContainer<E> {
    /**
     * size array.
     */
    private int size = 0;
    /**
     * Ponter first value.
     */
    private Node<E> first;
    /**
     * Ponter last value.
     */
    private Node<E> last;
    /**
     * @param e value objects.
     */
    @Override
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    /**
     * @param index position number.
     * @return value object.
     */
    @Override
    public E get(int index) {
        return (index >= 0 && index < size) ? getNode(index).object : null;
    }

    /**
     * @param index index
     * @return node Object
     */
    public Node<E> getNode(int index) {
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int atFirst = 0; atFirst < index; atFirst++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int fromEnd = size - 1; fromEnd > index; fromEnd--) {
                node = node.prev;
            }
            return node;
        }
    }

    /**
     * @param index index position number.
     * @param e  E
     */
    public void add(int index, E e) {
        if (index == size) {
            add(e);
        } else {
            final Node<E> succ = getNode(index);
            final Node<E> pred = succ.prev;
            final Node<E> newNode = new Node<>(pred, e, succ);
            succ.prev = newNode;
            if (pred == null) {
                first = newNode;
            } else {
                pred.next = newNode;
            }
            size++;
        }
    }

    /**
     * @return size array.
     */
    public int size() {
        return size;
    }

    /**
     * Method delete first element.
     */
    public void removeFirst() {
        if (size > 0) {
            Node<E> secondObject = this.first.next;
            secondObject.prev = null;
            this.first = secondObject;
            this.size--;
        } else {
            throw new NoSuchElementException();
        }
    }
    /**
     * Method delete last element.
     */
    public void removeLast() {
        if (size > 0) {
            Node<E> prevObjectLast = this.last.prev;
            prevObjectLast.next = null;
            this.last = prevObjectLast;
            this.size--;
        } else {
            throw new NoSuchElementException();
        }
    }



    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedArrayIterator();
    }

    /**
     * Node class storege pointer.
     * @param <E> type object.
     */
    public static class Node<E> {
        /**
         * object.
         */
        private E  object;
        /**
         * next pointer.
         */
        private Node<E> next;
        /**
         * prev pointer.
         */
        private Node<E> prev;

        /**
         * @param prev prev pointer.
         * @param element object.
         * @param next next pointer.
         */
        Node(Node<E> prev, E element, Node<E> next) {
            this.object = element;
            this.next = next;
            this.prev = prev;
        }


    }

    /**
     * implements Iterator methods.
     */
    public class LinkedArrayIterator implements Iterator<E> {
        /**
         * indexIterator.
         */
        private int indexIterator = 0;
        /**
         * nodeIterator.
         */
        private Node<E> nodeIterator = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return indexIterator < size ? true : false;
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
            if (indexIterator++ != 0) {
                nodeIterator = nodeIterator.next;
            }
            return nodeIterator.object;
        }
    }
}

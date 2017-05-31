package ru.rkhaustov.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <E> type object.
 */
public class SetLinked<E> implements SimpleSet<E> {
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
        Node<E> node = first;
        for (int atFirst = 0; atFirst < size; atFirst++) {
            if (e.equals(node.object)) {
                return;
            }
            node = node.next;
        }
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
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SetLinkedIterator();
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
    public class SetLinkedIterator implements Iterator<E> {
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

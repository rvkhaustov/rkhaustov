package ru.rkhaustov.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 03.06.2017.
 * @param <E> E extends Comparable<E>
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * dataTree.
     */
    private Node<E>[] dataTree;

    /**
     * @return dataTree.
     */
    public Node<E>[] getDataTree() {
        return dataTree;
    }
    /**
     * indexParent.
     */
    private  int indexParent = 0;
    /**
     * size.
     */
    private int size = 3;

    /**
     * @param <E> E extends Comparable<E>.
     */
    class Node<E> {
        /**
         * children.
//         * @param <E> E extends Comparable<E>.
         */
        private List<Node<E>> children;
        /**
         * value.
         */
        private E value;

        /**
         * @return children.
         */
        public List<Node<E>> getChildren() {
            return children;
        }

        /**
         * @return value.
         */
        public E getValue() {
            return value;
        }

        /**
         * @param value value.
         */
        Node(E value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
//        public Node() {
//        }


    }

    /**
     * Construction.
     */
    public Tree() {
        this.dataTree = new Node[size];
    }

    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        resize();

        Node<E> nodeParent = new Node<>(parent);
        Node<E> nodeChild = new Node<>(child);

        for (int index = 0; index < indexParent; index++) {
            E node = dataTree[index].value;
            if (compare(node, parent) == 0) {
                dataTree[index].children.add(nodeChild);
                return true;
            }
        }
            dataTree[indexParent] = nodeParent;
            dataTree[indexParent++].children.add(nodeChild);
        return true;
    }

    /**
     * @param o1 o1
     * @param o2 o2
     * @return 0 if =.
     */
    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }

    /**
     * resize dataTree.
     */
    public void resize() {
        if (indexParent >= size) {
            dataTree = Arrays.copyOf(dataTree, (int) (size * 1.5) + 1);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    /**
     * Iterator tree.
     */
    public class TreeIterator implements Iterator<E> {
        /**
         * parentIterator.
         */
        private int parentIterator = -1;
        /**
         * childIterator.
         */
        private int childIterator = 0;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return (parentIterator + (childIterator >= dataTree[parentIterator].children.size() ? 1 : 0)
                    >= indexParent && childIterator >= dataTree[parentIterator].children.size())
                    ? false : true;
        }


        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (parentIterator == -1 || childIterator >= dataTree[parentIterator].children.size()) {
                parentIterator++;
                childIterator = 0;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return dataTree[parentIterator].value;
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return dataTree[parentIterator].children.get(childIterator++).value;
        }
    }
}

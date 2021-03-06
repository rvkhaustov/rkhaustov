package ru.rkhaustov.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rvkha_000 on 03.06.2017.
 * @param <E> E extends Comparable<E>
 */

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * nodeTree.
     */
    private Node<E> nodeTree;

    /**
     * @return nodeTree.
     */
    public Node<E> getNodeTree() {
        return nodeTree;
    }

    /**
     * @param nodeTree nodeTree
     */
    public void setNodeTree(Node<E> nodeTree) {
        this.nodeTree = nodeTree;
    }

    /**
     * indexParent.
     */
    private  int indexParent = 0;
    /**
     * nodeBinary.
     */
    private boolean nodeBinary;


    /**
     * @param <E> E extends Comparable<E>.
     */
    class Node<E> {
        /**
         * children.
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
        if (nodeTree == null) {
            nodeTree = new Node<>(parent);
            nodeTree.children.add(new Node<>(child));
            indexParent++;
            return true;
        } else if (nodeTree.getValue() == parent) {
            nodeTree.children.add(new Node<>(child));
            indexParent++;
            return true;
        } else {
            addValue(nodeTree, parent, child);
        }
        return true;
    }

    /**
     * @param e add e.
     */
    void  add(E e) {

        Node<E> nodeNew = new Node<>(e);

        if (nodeTree == null) {
            nodeTree = nodeNew;
        } else {
            Node<E> nodeIndex = nodeTree;
            Node<E> nodeParent;
            int compareE = 0;
            while (true) {
                nodeParent = nodeIndex;
                compareE = compare(e, nodeIndex.getValue());
                if (compareE <= 0) {
                    createBinaryTree(nodeIndex);
                    nodeIndex = nodeIndex.getChildren().get(0);
                   if (nodeIndex == null) {
                       nodeParent.getChildren().set(0, nodeNew);
                       return;
                   }
                } else {

                    createBinaryTree(nodeIndex);
                    nodeIndex = nodeIndex.getChildren().get(1);
                    if (nodeIndex == null) {
                        nodeParent.getChildren().set(1, nodeNew);
                        return;
                    }
                }
            }
        }
    }

    /**
     * add left and right children.
     * @param nodeIndex node
     */
    void createBinaryTree(Node<E> nodeIndex) {
        while (nodeIndex.getChildren().size() < 2) {
            nodeIndex.getChildren().add(null);
        }
    }
    /**
     * @param node nide
     * @param parent parent
     * @param child child
     */
    public void  addValue(Node<E> node, E parent, E child) {
        E nodeValue;

        for (int indexList = 0; indexList < node.children.size(); indexList++) {
            nodeValue = node.children.get(indexList).getValue();
            if (compare(nodeValue, parent) == 0) {
                node = node.children.get(indexList);
                node.children.add(new Node<>(child));
                indexParent++;
                break;
            } else if (node.children.get(indexList).children.size() != 0) {
                addValue(node.children.get(indexList), parent, child);
            }
        }

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
     * @return true if tree binary, false if tree not binary
     *
     */
    public boolean isBinary() {
        nodeBinary = true;
        checkBinary(nodeTree);
        return nodeBinary;
    }

    /**
     * @param node node.
     */
    public void checkBinary(Node<E> node) {

        for (int indexList = 0; indexList < node.children.size(); indexList++) {
            if (node.children.size() > 2) {
                nodeBinary = false;
                break;
            }
            if (node.children.get(indexList).children.size() != 0) {
                checkBinary(node.children.get(indexList));
            }
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
         * indexIterator.
         */
        private int indexIterator = 0;
        /**
         * hasIterator.
         */
        private int nextIterator = 0;
        /**
         * nodeIterator.
         */
        private Node<E> nodeIterator = nodeTree;


        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return indexIterator > indexParent ? false : true;
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
            if (indexIterator == 0) {
                indexIterator++;
                return nodeTree.getValue();
            }
            nextIterator = 0;
            getValueIterator(nodeTree);
            indexIterator++;
            return nodeIterator.getValue();
        }


        /**
         * @param node node.
         */
        public void getValueIterator(Node<E> node) {

            for (int indexList = 0; indexList < node.children.size(); indexList++) {
                if (++nextIterator == indexIterator) {
                    nodeIterator = node.children.get(indexList);
                    break;
                }
                if (node.children.get(indexList).children.size() != 0) {
                    getValueIterator(node.children.get(indexList));
                }
            }

        }
    }
}





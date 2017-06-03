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
     * dataTree.
     */
    private Node<E> dataTree;

    /**
     * @return dataTree.
     */
    public Node<E> getDataTree() {
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
//        Node(Node node,E value) {
//            this.value = value;
//            this.children = new ArrayList<>();
//        }
//        public Node() {
//        }


    }

    /**
     * Construction.
     */
    public Tree() {
//        this.dataTree = new Node[size];
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
        if (dataTree == null) {
            dataTree = new Node<>(parent);
            dataTree.children.add(new Node<>(child));
            indexParent++;
            return true;
        } else if (dataTree.getValue() == parent) {
            dataTree.children.add(new Node<>(child));
            indexParent++;
            return true;
        } else {
            addValue(dataTree, parent, child);
        }


        return true;
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
        private int parentIterator = 0;
        /**
         * childIterator.
         */
        private int childIterator = 0;


        /**
         * list.
         */
        private List<E> list = new ArrayList<E>();


        /**
         * Construction.
         */
        public TreeIterator() {
            list.add(dataTree.getValue());
            fillList(dataTree);
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
//            return (parentIterator + (childIterator >= dataTree[parentIterator].children.size() ? 1 : 0)
//                    >= indexParent && childIterator >= dataTree[parentIterator].children.size())
//                    ? false : true;
            return parentIterator > indexParent ? false : true; // del
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
            return list.get(parentIterator++);
        }

        /**
         * @param node node.
         */
        public void  fillList(Node<E> node) {

            for (int indexList = 0; indexList < node.children.size(); indexList++) {
                    list.add(node.children.get(indexList).getValue());
                    if (node.children.get(indexList).children.size() != 0) {
                        fillList(node.children.get(indexList));
                }
            }

        }
    }
}

package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <T> type object.
 */
public class Cycle<T> {

    /**
     * @param first object.
     * @return false no cycle, true cycle.
     */
    boolean hasCycle(Node<T> first) {
        Node<T> node = first.getNext();
        while (node.getNext() != null) {
            node = node.getNext();
            if (first == node) {
                return true;
            }
        }
        return false;
    }
}

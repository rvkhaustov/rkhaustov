package ru.rkhaustov.list;

/**
 * Created by rvkha_000 on 31.05.2017.
 * @param <T> type object.
 */
class Node<T> {
    /**
     * value.
     */
    private T value;
    /**
     * next.
     */
    private Node<T> next;

    /**
     * @param value object.
     */
     Node(T value) {
        this.value = value;
    }

    /**
     * @return value
     */
    public T getValue() {
        return value;
    }

    /**
     * @return next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
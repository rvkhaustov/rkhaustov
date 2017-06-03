package ru.rkhaustov.tree;

/**
 * Created by rvkha_000 on 03.06.2017.
 * @param <E> E extends Comparable<E>
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent parent.
     * @param child child.
     * @return true
     */
    boolean add(E parent, E child);

}

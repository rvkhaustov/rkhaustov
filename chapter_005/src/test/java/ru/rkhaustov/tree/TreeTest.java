package ru.rkhaustov.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 03.06.2017.
 */
public class TreeTest {
    /**
     * Method add.
     */
    @Test
    public  void whenAddThenCorrectSave() {
        Tree<String> tree = new Tree<>();
        tree.add("first", "1");
        tree.add("first", "2");
        tree.add("second", "second 1");
        tree.add("third", "3");
        tree.add("forth", "4");
        tree.add("five", "5");

        assertThat(tree.getDataTree()[0].getValue(), is("first"));
        assertThat(tree.getDataTree()[0].getChildren().get(1).getValue(), is("2"));
    }
    /**
     * Method next Iterator.
     */
    @Test
    public  void whenNextIteratorThanTrue() {
        Tree<String> tree = new Tree<>();
        tree.add("first", "1");
        tree.add("first", "2");
        tree.add("second", "second 1");
        tree.add("third", "3");
        tree.add("forth", "4");
        tree.add("five", "5");
        Iterator<String> iterator = tree.iterator();

        assertThat(iterator.next(), is("first"));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.next(), is("2"));
        assertThat(iterator.next(), is("second"));
        assertThat(iterator.next(), is("second 1"));
    }
    /**
     * Method hasNext Iterator.
     */
 @Test
    public  void whenHasNextTnenFalse() {
        Tree<String> tree = new Tree<>();
        tree.add("first", "1");
        tree.add("first", "2");
        tree.add("second", "second 1");

        Iterator<String> iterator = tree.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();

        boolean result = iterator.hasNext();
    }

}
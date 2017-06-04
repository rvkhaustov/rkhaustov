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
     * Method add(E parent, E hild).
     */
    @Test
    public  void whenAddThenCorrectSave() {
        Tree<String> tree = new Tree<>();
        tree.add("P1", "P2");
        tree.add("P2", "P4");
        tree.add("P2", "P5");
        tree.add("P5", "P7");
        tree.add("P2", "P6");
        tree.add("P1", "P3");
        tree.add("P3", "P8");

        String result = tree.getNodeTree().getValue();
        assertThat(result, is("P1"));
        result = tree.getNodeTree().getChildren().get(0).getValue();
        assertThat(result, is("P2"));
        result = tree.getNodeTree().getChildren().get(1).getValue();
        assertThat(result, is("P3"));
        result = tree.getNodeTree().getChildren().get(0).getChildren().get(0).getValue();
        assertThat(result, is("P4"));
    }
    /**
     * Method next Iterator.
     */
    @Test
    public  void whenNextIteratorThanTrue() {
        Tree<String> tree = new Tree<>();
        tree.add("P1", "P2");
        tree.add("P2", "P4");
        tree.add("P2", "P5");
        tree.add("P5", "P7");
        tree.add("P2", "P6");
        tree.add("P1", "P3");
        tree.add("P3", "P8");
        Iterator<String> iterator = tree.iterator();

        assertThat(iterator.next(), is("P1"));
        assertThat(iterator.next(), is("P2"));
        assertThat(iterator.next(), is("P4"));
        assertThat(iterator.next(), is("P5"));
        assertThat(iterator.next(), is("P7"));
        assertThat(iterator.next(), is("P6"));
        assertThat(iterator.next(), is("P3"));
        assertThat(iterator.next(), is("P8"));

    }
    /**
     * Method hasNext Iterator.
     */
    @Test
    public  void whenHasNextTnenFalse() {
        Tree<String> tree = new Tree<>();
        tree.add("P1", "P2");
        tree.add("P2", "P4");
        tree.add("P2", "P5");

        Iterator<String> iterator = tree.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();


        boolean result = iterator.hasNext();
        assertThat(result, is(false));
    }
    /**
     * Method isBinary tree binary.
     */
    @Test
    public  void whenIsBinaryTreeBinaryThenTrue() {
        Tree<String> tree = new Tree<>();
        tree.add("P1", "P2");
        tree.add("P2", "P4");
        tree.add("P2", "P5");
        tree.add("P5", "P7");
        tree.add("P1", "P3");
        tree.add("P3", "P8");

        boolean result = tree.isBinary();
        assertThat(result, is(true));

    }
  /**
     * Method isBinary tree not binary.
     */
    @Test
    public  void whenIsBinaryTreeNotBinaryThenFalse() {
        Tree<String> tree = new Tree<>();
        tree.add("P1", "P2");
        tree.add("P2", "P4"); // P2 - three child
        tree.add("P2", "P5"); // P2 - three child
        tree.add("P5", "P7");
        tree.add("P2", "P6"); // P2 - three child
        tree.add("P1", "P3");
        tree.add("P3", "P8");

        boolean result = tree.isBinary();
        assertThat(result, is(false));

    }

    /**
     * Method add(E e).
     */
    @Test
    public  void whenAddEThenSortSave() {
        Tree<String> tree = new Tree<>();
        tree.add("9");  //           9
        tree.add("2");  //         /    \
        tree.add("4");  //      2
        tree.add("7");  //       \
        tree.add("6");  //        4
        tree.add("8");  //       / \
        tree.add("3");  //      3   7
        tree.add("5");  //         / \
//                                6   8
//                              /
//                             5

        System.out.println();

        String result = tree.getNodeTree().getValue();
        assertThat(result, is("9"));

        result = tree.getNodeTree().getChildren().get(0).getValue();
        assertThat(result, is("2"));

        tree.setNodeTree(tree.getNodeTree().getChildren().get(0));
        result = tree.getNodeTree().getChildren().get(1).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("4"));

        tree.setNodeTree(tree.getNodeTree().getChildren().get(1));
        result = tree.getNodeTree().getChildren().get(0).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("3"));
        result = tree.getNodeTree().getChildren().get(1).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("7"));

        tree.setNodeTree(tree.getNodeTree().getChildren().get(1));
        result = tree.getNodeTree().getChildren().get(0).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("6"));
        result = tree.getNodeTree().getChildren().get(1).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("8"));

        tree.setNodeTree(tree.getNodeTree().getChildren().get(0));
        result = tree.getNodeTree().getChildren().get(0).getValue(); // .getChildren().get(0).getValue();
        assertThat(result, is("5"));

    }

}
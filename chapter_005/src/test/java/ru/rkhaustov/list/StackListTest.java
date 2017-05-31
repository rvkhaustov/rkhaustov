package ru.rkhaustov.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 31.05.2017.
 */
public class StackListTest {
    /**
     * test method push <String>.
     */
    @Test
    public void  whenPushStringThenGetString() {
        StackList<String> list = new StackList<>();

        list.push("first");
        list.push("second");

        String result =  list.getLinkedArray().get(0);
        assertThat(result, is("first"));
        result =  list.getLinkedArray().get(1);
        assertThat(result, is("second"));

    }
    /**
     * test method pop <String>.
     */
    @Test
    public void  whenPopStringThenGetFirstObjectAndDel() {
        StackList<String> list = new StackList<>();

        list.push("first");
        list.push("second");
        list.push("third");

        String result =  list.pop();
        assertThat(result, is("third"));

        result =  list.getLinkedArray().get(0);
        assertThat(result, is("first"));

        result =  list.getLinkedArray().get(1);
        assertThat(result, is("second"));

    }
}
package ru.rkhaustov.models;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test StubInputTest - substitution of user input.
 * @author rvkhaustov
 * @version 1.0
 * @since 04.2017
 */
public class StubInpitTest {
    /**
     * test item 0. Add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // create Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //Create StubInput with a sequence of actions
        new StartUI(input, tracker).init();     //   Create StartUI and call the method init()
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    /**
     * Test item 1. Show all items.
     */
    @Test
    public void whenUserShowItemThenTrackerGetAll() {
        Tracker tracker = new Tracker();     // create Tracker
        String lineSeparator = System.getProperty("line.separator");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Item itemFirst = new Item("test1", "testDescription1", 123L);
        tracker.add(itemFirst);

        Item itemSecond = new Item("test2", "testDescription2", 223L);
        tracker.add(itemSecond);

        Input input = new StubInput(new String[]{"1", "y"});   //Create StubInput with a sequence of actions

        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();

        StringBuilder sbExpected = new StringBuilder();
        sbExpected.append(itemFirst.toString());
        sbExpected.append(lineSeparator);
        sbExpected.append(itemSecond.toString());
        sbExpected.append(lineSeparator);

        String expected = sbExpected.toString();
        String result = out.toString().substring((out.toString().length() - expected.length()));
        assertThat(result, is(expected));
    }
    /**
     * test item 2. Edit.
     */
    @Test
    public void whenUserEditItemThenTrackerHasUpdateItemWithSameName() {
        Tracker tracker = new Tracker();     // create Tracker

        Item item = new Item("test1", "testDescription1", 123L);
        String id;
        tracker.add(item);
        id = item.getId();
        String excpected = "Edit";

        Input input = new StubInput(new String[]{"2", id, excpected, "Update", "y"});   //Create StubInput with a sequence of actions
        new StartUI(input, tracker).init();

        String result = tracker.getAll()[0].getName();
        assertThat(result, is(excpected));
    }
    /**
     * test item 3. Delete.
     */
    @Test
    public void whenUserDeleteItemThenTrackerHasNewItem() {
        Tracker tracker = new Tracker();     // create Tracker

        Item item = new Item("test1", "testDescription1", 123L);
        String id;
        tracker.add(item);
        id = item.getId();
        item = new Item("test2", "testDescription2", 223L);
        tracker.add(item);

        String excpected = "test2";
        Input input = new StubInput(new String[]{"3", id, "y"});
        new StartUI(input, tracker).init();
        String result = tracker.getAll()[0].getName();
        assertThat(result, is(excpected));
    }
    /**
     * test item 4. Find item by Id.
     */
    @Test
    public void whenUserFindByIdItemThenTrackerfindById() {
        Tracker tracker = new Tracker();     // create Tracker
        String lineSeparator = System.getProperty("line.separator");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Item itemFirst = new Item("test1", "testDescription1", 123L);
        tracker.add(itemFirst);
        String idFind = itemFirst.getId();

        tracker.add(new Item("test2", "testDescription2", 223L));

        Input input = new StubInput(new String[]{"4", idFind, "y"});
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();

        String expected = String.format("Id: %16s; Name: %10s; Description: %20s; Date: %s%s",
                itemFirst.getId(), itemFirst.getName(), itemFirst.getDesc(), new Date(itemFirst.getCreated()).toString(), lineSeparator
        );

        String result = out.toString().substring((out.toString().length() - expected.length()));
        assertThat(result, is(expected));
    }
    /**
     * test item 5. Find item by Name.
     */
    @Test
    public void whenUserFindByNameItemThenTrackerfindByName() {
        Tracker tracker = new Tracker();     // create Tracker
        String lineSeparator = System.getProperty("line.separator");
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Item itemFirst = new Item("test1", "testDescription1", 123L);
        tracker.add(itemFirst);

        Item itemSecond = new Item("test1", "testDescription2", 223L);
        tracker.add(itemSecond);

        Input input = new StubInput(new String[]{"5", "test1", "y"});
        System.setOut(new PrintStream(out));
        new StartUI(input, tracker).init();

        StringBuilder sbExpected = new StringBuilder();
        sbExpected.append(itemFirst.toString());
        sbExpected.append(lineSeparator);
        sbExpected.append(itemSecond.toString());
        sbExpected.append(lineSeparator);

        String expected = sbExpected.toString();

        String result = out.toString().substring((out.toString().length() - expected.length()));
        assertThat(result, is(expected));
    }
    /**
     * Test exception.
     * @throws MenuOutException   exception select menu.
     */
    @Test (expected = MenuOutException.class)
    public void testException() throws MenuOutException {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"7", "y"});
        new StartUI(input, tracker).init();

    }



}

package ru.rkhaustov.models;

import org.junit.Test;

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
     * test item 1. Add.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // create Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //Create StubInput with a sequence of actions
        new StartUI(input, tracker).init();     //   Create StartUI and call the method init()
        assertThat(tracker.getAll()[0].getName(), is("test name"));
    }
    /**
     * test item 2. show.
     */
    @Test
    public void whenUserShowItemThenTrackerGetAll() {
        Tracker tracker = new Tracker();     // create Tracker

        Item item = new Item("test1", "testDescription1", 123L);
        String id;
        String date;
        tracker.add(item);
        id = item.getId();
        date = new Date(item.getCreated()).toString();
        String excpectedFirst = "Id: " + id + "; Name: test1; Description: testDescription1; Date: " + date;

        item = new Item("test2", "testDescription2", 223L);
        tracker.add(item);
        id = item.getId();
        date = new Date(item.getCreated()).toString();
        String excpectedSecond = "Id: " + id + "; Name: test2; Description: testDescription2; Date: " + date;

        Input input = new StubInput(new String[]{"1", "6"});   //Create StubInput with a sequence of actions

        assertThat(new StartUI(input, tracker).printItem(tracker.getAll())[0], is(excpectedFirst));
        assertThat(new StartUI(input, tracker).printItem(tracker.getAll())[1], is(excpectedSecond));
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

        Input input = new StubInput(new String[]{"2", id, "Edit", "Update", "6"});   //Create StubInput with a sequence of actions
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
        Input input = new StubInput(new String[]{"3", id, "6"});
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

        Item item = new Item("test1", "testDescription1", 123L);
        String id;
        String date;
        tracker.add(item);
        id = item.getId();
        date = new Date(item.getCreated()).toString();
        String excpected = "Id: " + id + "; Name: test1; Description: testDescription1; Date: " + date;

        item = new Item("test2", "testDescription2", 223L);
        tracker.add(item);

        Input input = new StubInput(new String[]{"4", id, "6"});   //создаём StubInput с последовательностью действий
        assertThat(new StartUI(input, tracker).printItem(tracker.findById(id)), is(excpected)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.

    }
    /**
     * test item 5. Find item by Name.
     */
    @Test
    public void whenUserFindByNameItemThenTrackerfindByName() {
        Tracker tracker = new Tracker();     // create Tracker

        Item item = new Item("test1", "testDescription1", 123L);
        String id;
        String date;
        tracker.add(item);
        id = item.getId();
        date = new Date(item.getCreated()).toString();
        String excpected = "Id: " + id + "; Name: test1; Description: testDescription1; Date: " + date;

        item = new Item("test2", "testDescription2", 223L);
        tracker.add(item);

        Input input = new StubInput(new String[]{"5", "test1", "6"});   //создаём StubInput с последовательностью действий
        assertThat(new StartUI(input, tracker).printItem(tracker.findByName("test1"))[0], is(excpected)); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.

    }


}

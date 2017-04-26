package ru.rkhaustov.models;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by rvkha_000 on 24.04.2017.
 * @version  1.0
 * @since 04.2017
 */
public class TrackerTest {
    /**
     * Test Adds an application.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }
    /**
     * Test update.
     */
    @Test
    public void whenUpdateNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription1", 123L);
        Item itemF = new Item("test2", "testDescription2", 223L);
        Item itemUpdate = new Item("TestUpdate", "testDescriptionUpdate", 333);
        String id;
        tracker.add(item);
        id = item.getId();
        tracker.add(itemF);
        itemUpdate.setId(id);
        tracker.update(itemUpdate);
        assertThat(tracker.getAll()[0], is(itemUpdate));
    }
    /**
     * Test update an application.
     */
    @Test
    public void whenDeleteNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription1", 123L);
        Item itemF = new Item("test1", "testDescription2", 223L);
        Item itemS = new Item("Test2", "testDescriptionUpdate", 333);
        Item itemT = new Item("Test3", "testDescriptionUpdate", 333);
        tracker.add(item);
        tracker.add(itemF);
        tracker.add(itemS);
        tracker.add(itemT);

        tracker.delete(itemF);
        assertThat(tracker.getAll()[1], is(itemS));
    }
    /**
     * Test findAll an application.
     */
    @Test
    public void whenFindAllNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription1", 123L);
        Item itemF = new Item("test1", "testDescription2", 223L);
        Item itemS = new Item("Test2", "testDescriptionUpdate", 333);
        Item itemT = new Item("Test3", "testDescriptionUpdate", 333);
        tracker.add(item);
        tracker.add(itemF);
        tracker.add(itemS);
        tracker.add(itemT);

        tracker.delete(itemF);
        assertThat(tracker.getAll(), is(tracker.findAll()));
    }

    /**
     * Test findByName.
     */
    @Test
    public void whenFindBaNameNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription1", 123L);
        Item itemF = new Item("test", "testDescription2", 223L);
        Item itemS = new Item("Test2", "testDescription3", 333);
        Item itemT = new Item("test", "testDescription4", 433);
        tracker.add(item);
        tracker.add(itemF);
        tracker.add(itemS);
        tracker.add(itemT);
        assertThat(tracker.findByName("test")[0], is(itemF));
        assertThat(tracker.findByName("test")[1], is(itemT));
    }
    /**
     * Test FindById.
     */
    @Test
    public void whenFindByIdNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test0", "testDescription1", 123L);
        Item itemF = new Item("test1", "testDescription2", 223L);
        Item itemS = new Item("test2", "testDescriptionUpdate", 333L);
        Item itemNull = null;
        String id;
        tracker.add(item);
        tracker.add(itemF);
        tracker.add(itemS);
        id = itemF.getId();
        assertThat(tracker.findById(id), is(itemF));
        id = "1";
        assertThat(tracker.findById(id), is(itemNull));

    }
}

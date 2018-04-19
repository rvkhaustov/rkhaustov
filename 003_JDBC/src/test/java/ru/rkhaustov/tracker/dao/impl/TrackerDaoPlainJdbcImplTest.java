package ru.rkhaustov.tracker.dao.impl;

import org.junit.After;
import org.junit.Test;
import ru.rkhaustov.tracker.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static ru.rkhaustov.tracker.dao.impl.TrackerDaoPlainJdbcImpl.CONFIG_PROPERTIES;
import static ru.rkhaustov.tracker.dao.impl.TrackerDaoPlainJdbcImpl.CONFIG_PROPERTIES_ABS_PATH;

/**
 * Created by rvkha_000 on 19.04.2018.
 */
public class TrackerDaoPlainJdbcImplTest {
    /**
     * items for del form database.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * tearDown.
     */
    @After
    public void tearDown() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        items.forEach(trackerDaoPlainJdbc::delete);
        items.clear();
    }

    /**
     * initStatus_abs_path_Success.
     */
    @Test
    public void initStatusAbsPathSuccess() {
        System.setProperty(CONFIG_PROPERTIES, CONFIG_PROPERTIES_ABS_PATH + CONFIG_PROPERTIES);
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        boolean expected = trackerDaoPlainJdbc.initStatus();
        assertTrue(expected);
    }

    /**
     * initStatus_abs_path_Error_FileNotFoundException.
     */
    @Test
    public void initStatusAbsPathErrorFileNotFoundException() {
        System.setProperty(CONFIG_PROPERTIES, CONFIG_PROPERTIES_ABS_PATH + "");
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        System.setProperty(CONFIG_PROPERTIES, CONFIG_PROPERTIES_ABS_PATH + CONFIG_PROPERTIES);
        boolean expected = trackerDaoPlainJdbc.initStatus();
        assertFalse(expected);
    }

    /**
     * initStatus_abs_path_Error_ClassNotFoundException.
     */
    @Test
    public void initStatusAbsPathErrorClassNotFoundException() {
        System.setProperty(CONFIG_PROPERTIES, CONFIG_PROPERTIES_ABS_PATH + "testDriver.properties");
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        boolean expected = trackerDaoPlainJdbc.initStatus();
        assertFalse(expected);
    }

    /**
     * add.
     */
    @Test
    public void add() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        String id = trackerDaoPlainJdbc.generatID();
        Item expected = new Item(id, "add", "add", "add", 5L);
        trackerDaoPlainJdbc.add(expected);
        items.add(expected);
        Item result = trackerDaoPlainJdbc.findById(id);
        assertThat(result.getId(), is(expected.getId()));
        assertThat(result.getName(), is(expected.getName()));
        assertThat(result.getComments(), is(expected.getComments()));
        assertThat(result.getCreated(), is(expected.getCreated()));
        assertThat(result.getDescription(), is(expected.getDescription()));
    }

    /**
     * getAll.
     */
    @Test
    public void getAll() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        for (int i = 0; i < 10; i++) {
            Item item = new Item(trackerDaoPlainJdbc.generatID(), "getAll", "getAll", "getAll", 4L);
            trackerDaoPlainJdbc.add(item);
            items.add(item);
        }
        int result = trackerDaoPlainJdbc.getAll().size();
        assertTrue(result > 9);
    }

    /**
     * update.
     */
    @Test
    public void update() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        String id = trackerDaoPlainJdbc.generatID();
        Item expected = new Item(id, "update", "update", "update", 4L);
        trackerDaoPlainJdbc.add(expected);
        items.add(expected);
        expected = new Item(id, "change", "change", "change", 5L);
        trackerDaoPlainJdbc.update(expected);
        Item result = trackerDaoPlainJdbc.findById(id);
        assertThat(result.getId(), is(expected.getId()));
        assertThat(result.getName(), is(expected.getName()));
        assertThat(result.getComments(), is(expected.getComments()));
        assertThat(result.getCreated(), is(expected.getCreated()));
        assertThat(result.getDescription(), is(expected.getDescription()));
    }

    /**
     * delete.
     */
    @Test
    public void delete() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        String id = trackerDaoPlainJdbc.generatID();
        Item expected = new Item(id, "delete", "delete", "delete", 4L);
        trackerDaoPlainJdbc.add(expected);
        items.add(expected);
        trackerDaoPlainJdbc.delete(expected);
        Item result = trackerDaoPlainJdbc.findById(id);
        assertNull(result.getId());
    }

    /**
     * findByName.
     */
    @Test
    public void findByName() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        String name = trackerDaoPlainJdbc.generatID();
        Item expected = new Item(name, name, "findByName", "findByName", 4L);
        trackerDaoPlainJdbc.add(expected);
        items.add(expected);
        Item result = trackerDaoPlainJdbc.findByName(name).get(0);
        assertThat(result.getName(), is(expected.getName()));
        assertThat(result.getComments(), is(expected.getComments()));
        assertThat(result.getCreated(), is(expected.getCreated()));
        assertThat(result.getDescription(), is(expected.getDescription()));
    }


    /**
     * findById.
     */
    @Test
    public void findById() {
        TrackerDaoPlainJdbcImpl trackerDaoPlainJdbc = new TrackerDaoPlainJdbcImpl();
        String id = trackerDaoPlainJdbc.generatID();
        Item expected = new Item(id, "findById", "findById", "findById", 4L);
        trackerDaoPlainJdbc.add(expected);
        items.add(expected);
        Item result = trackerDaoPlainJdbc.findById(id);
        assertThat(result.getName(), is(expected.getName()));
        assertThat(result.getComments(), is(expected.getComments()));
        assertThat(result.getCreated(), is(expected.getCreated()));
        assertThat(result.getDescription(), is(expected.getDescription()));
    }

}
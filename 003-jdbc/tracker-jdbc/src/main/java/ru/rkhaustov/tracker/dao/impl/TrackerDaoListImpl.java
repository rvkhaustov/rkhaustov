package ru.rkhaustov.tracker.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rkhaustov.tracker.Item;
import ru.rkhaustov.tracker.dao.TrackerDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rvkha_000 on 24.04.2017.
 *
 * @version 1.0
 */
public class TrackerDaoListImpl implements TrackerDao {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackerDaoListImpl.class);
    /**
     * @param item - class item
     */
    private List<Item> items = new ArrayList<Item>();


    /**
     * Method add - add item.
     *
     * @param item add item
     * @return id
     */
    public Long add(Item item) {
        item.setId(generatID());
        this.items.add(item);
        return Long.valueOf(items.size());
    }

//    /**
//     * @return random value
//     */
//    String generatID() {
//        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
//    }

    /**
     * @return item
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * @param item update
     */
    public void update(Item item) {
        String searchID = item.getId();
        for (int index = 0; index != this.items.size(); index++) {
            if (this.items.get(index) != null && items.get(index).getId().equals(searchID)) {
                this.items.set(index, item);
                break;
            }
        }
    }

    /**
     * @param item delete
     */
    public void delete(Item item) {
        String searchID = item.getId();
        for (int index = 0; index != this.items.size(); index++) {
            if (this.items.get(index) != null && this.items.get(index).getId().equals(searchID)) {
                this.items.remove(index);
                break;
            }
        }
    }

    /**
     * findByName.
     *
     * @param key search name
     * @return List item
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<Item>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * @param id search id
     * @return item
     */
    public Item findById(String id) {
        Item result = new Item();
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @return true else initialization success, else false.
     */
    @Override
    public boolean initStatus() {
        return true;
    }


}

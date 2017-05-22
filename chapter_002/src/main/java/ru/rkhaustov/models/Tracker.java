package ru.rkhaustov.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by rvkha_000 on 24.04.2017.
 * @version 1.0
 */
public class Tracker {
    /**
     * @param item - class item
     */
    private List<Item> items = new ArrayList<Item>();
    /**
     * @param RN random value
     */
    private static final Random RN = new Random();


    /**
     * Method add - add item.
     * @param item add item
     * @return item
     */
    public Item add(Item item) {
        item.setId(this.generatID());
        this.items.add(item);
        return item;
    }

    /**
     *
     * @return random value
     */
    String generatID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     *
     * @return item
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     *
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
     *
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
     *
     * @param id search id
     * @return item
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}

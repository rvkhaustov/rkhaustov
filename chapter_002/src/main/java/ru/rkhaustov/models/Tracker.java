package ru.rkhaustov.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import java.util.Arrays;


/**
 * Created by rvkha_000 on 24.04.2017.
 * @version 1.0
 */
public class Tracker {
//    /**
//     * @param countI count items
//     */
//    private int countI = 10;
    /**
     * @param item - class item
     */
    private List<Item> items = new ArrayList<Item>();
//    private Item[] items = new Item[countI];
//    /**
//     * @param position
//     */
//    private int position = 0;
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
//        Item[] result = new Item[this.items.size()];
        List<Item> result = new ArrayList<Item>();
        for (int index = 0; index != this.items.size(); index++) {
            result.add(this.items.get(index));
        }
        return result;
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
//                System.arraycopy(this.items, index + 1, this.items, index,  this.position - index);
//                this.position--;
                this.items.remove(index);
                break;
            }
        }
    }
    /**
     * findAll.
     * @return item
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<Item>();
        for (int index = 0; index != this.items.size(); index++) {
            result.add(this.items.get(index));
        }
        return result;
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
        int countName = 0;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

}

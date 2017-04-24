package ru.job4j.models;

import java.util.Random;
import java.util.Arrays;


/**
 * Created by rvkha_000 on 24.04.2017.
 * @version 1.0
 */
public class Tracker {
    /**
     * @param countI count items
     */
    private int countI = 10;
    /**
     * @param item - class item
     */
    private Item[] items = new Item[countI];
    /**
     * @param position
     * @param RN random value
     */
    private int position = 0;
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
        this.items[position++] = item;
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
    public Item[] getAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     *
     * @param item update
     */
    public void update(Item item) {
        String searchID = item.getId();
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && items[index].getId().equals(searchID)) {
                this.items[index] = item;
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
        for (int index = 0; index != this.position; index++) {
            if (this.items[index] != null && items[index].getId().equals(searchID)) {
                System.arraycopy(this.items, index + 1, this.items, index,  this.position - index);
                this.position--;
                break;
            }
        }
    }
    /**
     * findAll.
     * @return item
     */
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * findByName.
     * @param key search name
     * @return item[]
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.countI];
        int countName = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[countName++] = item;
            }
        }
        return Arrays.copyOf(result, countName);
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

package ru.rkhaustov.tracker.dao;

import ru.rkhaustov.tracker.Item;

import java.util.List;
import java.util.Random;

/**
 * Created by rvkha_000 on 12.04.2018.
 */
public interface TrackerDao {
    /**
     * Method add - add item.
     *
     * @param item add item
     * @return id
     */
    Long add(Item item);

    /**
     * @return collection all items.
     */
    List<Item> getAll();

    /**
     * @param item update
     */
    void update(Item item);

    /**
     * @param item delete
     */
    void delete(Item item);
    /**
     * findByName.
     *
     * @param key search name
     * @return List item
     */
    List<Item> findByName(String key);
    /**
     * @param id search id
     * @return item
     */
    Item findById(String id);

    /**
     * @return true else initialization success, else false.
     */
    boolean initStatus();

    /**
     * @param RN random value
     */
    Random RN = new Random();

    /**
     * @return random value
     */
    default String generatID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}

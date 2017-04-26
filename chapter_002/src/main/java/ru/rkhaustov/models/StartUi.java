package ru.rkhaustov.models;

import java.util.Date;

/**
 * Class StartUi entry point in the program.
 * @version 1.0
 * @since 04.2017
 */


public class StartUi {
    /**
     * @param input keybord
     */
    private Input input;

    /**
     * Constructor class StartUi initialization i/o.
     * @param input initialization i/o
     */
    public StartUi(Input input) {
        this.input = input;
    }
    /**
     * @param tracker class Tracker
     */
    private Tracker tracker = new Tracker();

    /**
     * init - init main.
     */
    public void init() {
        String[] menuName = {
                "0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program"};
        String itemMenu;

        do {
            for (String item : menuName) {
                System.out.println(item);
            }
            itemMenu = input.ask("Please, enter the task's name from 1 to 6: ");
            if (itemMenu.equals("0")) {
                tracker.add(inpitItem("add"));
            } else if (itemMenu.equals("1")) {
                printItem(tracker.getAll());
            } else if (itemMenu.equals("2")) {
                tracker.update(inpitItem("update"));
            } else if (itemMenu.equals("3")) {
                tracker.delete(inpitItem("del"));
            } else if (itemMenu.equals("4")) {
                printItem(tracker.findById(input.ask("Please, enter Id: ")));
            } else if (itemMenu.equals("5")) {
                printItem(tracker.findByName(input.ask("Please, enter Name: ")));
            }

        } while (!itemMenu.equals("6"));
        System.out.println("Good bay");

    }

    /**
     * Output on display.
     * @param items class items array
     */
    void printItem(Item[] items) {
        Date date = new Date();
        for (Item item : items) {
            date = new Date(item.getCreated());
            System.out.println("Id - " + item.getId()
                    + "; Name - " + item.getName()
                    + "; Description -" + item.getDesc()
                    + "; Date - " + date.toString());
        }
    }

    /**
     * Output on display.
     * @param item class item
     */
    void printItem(Item item) {
        Date date = new Date();
        date = new Date(item.getCreated());
        System.out.println("Id - " + item.getId()
                + "; Name - " + item.getName()
                + "; Description -" + item.getDesc()
                + "; Date - " + date.toString());
    }

    /**
     * Input user data.
     * @param act methods add, update, delete item.
     * @return executed array
     */
    Item inpitItem(String act) {
        String id = null;
        String name = null;
        String desc = null;
        long created = 0;
        if (act.equals("update") || act.equals("del")) {
            id = input.ask("Please, enter Id: ");
        } else if (!act.equals("del")) {
            name = input.ask("Please, enter name: ");
            desc = input.ask("Please, enter description: ");
            Date date = new Date();
            created = date.getTime();
        }
        return (act.equals("add")) ? new Item(name, desc, created) : new Item(id, name, desc, created);
    }

    /**
     * Method main for start apllication.
     * @param args params
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        new StartUi(input).init();
    }
}
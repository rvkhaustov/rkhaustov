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
     * Enum const item menu.
     */
    public enum ItemMenu {
        /**
         * @param ADD - item add
         */
        ADD("0"),
        /**
         * @param SHOW - item show
         */
        SHOW("1"),
        /**
         * @param EDIT - item edit
         */
        EDIT("2"),
        /**
         * @param DELETE - item delete
         */
        DELETE("3"),
        /**
         * @param FINDid - item find id
         */
        FINDid("4"),
        /**
         * @param FINDname - item find name
         */
        FINDname("5"),
        /**
         * @param EXIT - exit application
         */
        EXIT("6");
        /**
         * @param item - value item
         */
        private String item;

        /**
         *
         * @param item construction Initialize item from 0 to 6
         */
        ItemMenu(String item) {
            this.item = item;
        }

        /**
         * Getter item.
         * @return get item from 0 to 6.
         */
        public String gettItem() {
            return this.item;
        }
    }


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
        String askItemMenu;


        do {
            for (String item : menuName) {
                System.out.println(item);
            }
//            ItemMenu itemmenu1 = (ItemMenu) Enum.valueOf(ItemMenu.class,("item" + input.ask("Please, 11enter the task's name from 1 to 6: ")));
            askItemMenu = input.ask("Please, enter the task's name from 1 to 6: ");
//            System.out.println(askItemMenu);
//            System.out.println(ItemMenu.ADD.gettItem());
            if (askItemMenu.equals(ItemMenu.ADD.gettItem())) {
                tracker.add(inpitItemAdd());
            } else if (askItemMenu.equals(ItemMenu.SHOW.gettItem())) {
                printItem(tracker.getAll());
            } else if (askItemMenu.equals(ItemMenu.EDIT.gettItem())) {
                tracker.update(inpitItemUpdate());
            } else if (askItemMenu.equals(ItemMenu.DELETE.gettItem())) {
                tracker.delete(new Item(input.ask("Please, enter Id: "), null, null, 0));
            } else if (askItemMenu.equals(ItemMenu.FINDid.gettItem())) {
                printItem(tracker.findById(input.ask("Please, enter Id: ")));
            } else if (askItemMenu.equals(ItemMenu.FINDname.gettItem())) {
                printItem(tracker.findByName(input.ask("Please, enter Name: ")));
            }

        } while (!askItemMenu.equals(ItemMenu.EXIT.gettItem())); //askItemMenu == itemMenu.item6.toString()
        System.out.println("Good bay");

    }

    /**
     * Output on display items[].
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
     * Output on display item.
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
     * Input user data ADD.
     * @return executed array item
     */
    Item inpitItemAdd() {
        String name = input.ask("Please, enter name: ");
        String desc = input.ask("Please, enter description: ");
        Date date = new Date();
        long created = date.getTime();
        return new Item(name, desc, created);
    }
    /**
     * Input user data method Update.
     * @return executed array
     */
    Item inpitItemUpdate() {

        String id = input.ask("Please, enter Id: ");
        String  name = input.ask("Please, enter name: ");
        String desc = input.ask("Please, enter description: ");
        Date date = new Date();
        long created = date.getTime();

        return  new Item(id, name, desc, created);
    }

    /**
     * Method main for start application.
     * @param args params
     */
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        new StartUi(input).init();
    }
}
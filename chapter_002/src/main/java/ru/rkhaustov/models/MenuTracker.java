package ru.rkhaustov.models;

import java.util.Date;

/**
 * EditItem - External inner class. Edit the item.
 */
class EditItem implements UserAction {
    /**
     *
     * @return Number item.
     */
    public int key() {
        return 2;
    }

    /**
     *
     * @return item menu.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Edit the item");
    }

    /**
     *
     * @param input - select item.
     * @param tracker reference on tracker.
     */
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please, enter id: ");
        String name = input.ask("Please, enter name: ");
        String desc = input.ask("Please, enter description: ");
        long created = new Date().getTime();
        tracker.update(new Item(id, name, desc, created));
    }
}
/**
 * StubInput - substitution of user input.
 * @author rvkhaustov
 * @version 1.0
 * @since 04.2017
 */
public class MenuTracker {
    /**
     * @param input - input.
     */
    private Input input;
    /**
     * @param tracker - tracker.
     */
    private Tracker tracker;
    /**
     * @param actions array user action.
     */
    private UserAction[] actions = new UserAction[6];

    /**
     * Constructor class MenuTracker initialization.
     * @param input - select item.
     * @param tracker reference on tracker.
     */

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fillAction - fill action item.
     */
    public void fillAction() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindId();
        this.actions[5] = this.new FindName();
    }
//    public static void test(){ // An example of a static inner class
//        MenuTracker tr = new MenuTracker(this.input, this.tracker);
//        AddItem addItem = tr.new AddItem();
//        this.actions[1] = new ShowItems();
//    }

    /**
     * Select action item.
     * @param key - item menu.
     */
    public  void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Show print action.
     */
    public void  show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Inner class - 0. Add the new item.
     */
    private class AddItem implements UserAction {
        /**
         *
         * @return number item menu 0. Add the new item
         */
        public int key() {
            return 0;
        }

        /**
         *
         * @return string menu.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }

        /**
         *
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter name: ");
            String desc = input.ask("Please, enter description: ");
            long created = new Date().getTime();
            tracker.add(new Item(name, desc, created));
        }
    }

    /**
     * Inner class - Show all items.
     */
    private static class ShowItems implements UserAction {
        /**
         *
         * @return number item menu.
         */
        public int key() {
            return 1;
        }

        /**
         *
         * @return string menu.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }

        /**
         *
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, Tracker tracker) {
//            MenuTracker menuTracker = new MenuTracker();
            for (Item item : tracker.getAll()) {
//                System.out.println(new MenuTracker(input, tracker).itemString(item));
                System.out.println(item.toString());
            }
        }
    }
    /**
     * Inner class - Delete the item.
     */
    class DeleteItem implements UserAction {
        /**
         *
         * @return number item menu.
         */
        public int key() {
            return 3;
        }

        /**
         *
         * @return string menu.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete the item");
        }

        /**
         *
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter id: ");
            tracker.delete(new Item(id, null, null, 0));
        }
    }
    /**
     * Inner class - Find item by Id.
     */
    class FindId implements UserAction {
        /**
         *
         * @return number item menu.
         */
        public int key() {
            return 4;
        }

        /**
         *
         * @return string menu.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id");
        }

        /**
         *
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Please, enter id: ");
            System.out.println(tracker.findById(id).toString());
        }
    }
    /**
     * Inner class - Find items by name.
     */
    class  FindName implements UserAction {
        /**
         *
         * @return number item menu.
         */
        public int key() {
            return 5;
        }

        /**
         *
         * @return string menu.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }

        /**
         *
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter name: ");
            for (Item item: tracker.findByName(name)) {
                System.out.println(item.toString());
            }
        }
    }

    /**
     * itemString - preparing the string.
     * @param item reference on item.
     * @return string for print.
     */
//    String itemString(Item item) {
//        return String.format("Id: %16s; Name: %10s; Description: %20s; Date: %s",
//                item.getId(),
//                item.getName(),
//                item.getDesc(),
//                new Date(item.getCreated()).toString());
//    }
}

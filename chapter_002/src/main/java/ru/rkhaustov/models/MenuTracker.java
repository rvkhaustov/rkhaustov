package ru.rkhaustov.models;

import java.util.Date;

/**
 * EditItem - External inner class. Edit the item.
 */
class EditItem extends BaseAction {

    /**
     * Construction string menu.
     */
    EditItem() {
        super(2, "Edit the item");
    }

    /**
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
     * fillRange.
     * @param range Possible menu items.
     * @return select menu items.
     */
    public int[] fillRange(int[] range) {
        range = new int[this.actions.length];
        int index = 0;
        for (UserAction action : this.actions) {
            range[index++] = action.key();
        }
        return range;
    }

    /**
     * Inner class - 0. Add the new item.
     */
    private class AddItem extends BaseAction {
        /**
         * Construction string menu.
         */
        AddItem() {
            super(0, "Add the new item");
        }

        /**
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
    private static class ShowItems extends BaseAction {
        /**
         *  Construction string menu.
         */
        ShowItems() {
            super(1, "Show all items");
        }

        /**
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
    class DeleteItem extends BaseAction {
        /**
         * Construction string menu.
         */
        DeleteItem() {
            super(3, "Delete the item");
        }

        /**
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
    class FindId extends BaseAction {
        /**
         * Construction string menu.
         */
        FindId() {
            super(4, "Find item by Id");
        }

        /**
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
    class  FindName extends BaseAction {
        /**
         * Construction string menu.
         */
        FindName() {
            super(5, "Find items by name");
        }

        /**
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

}

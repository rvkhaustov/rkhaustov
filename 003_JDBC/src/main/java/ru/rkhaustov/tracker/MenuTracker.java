package ru.rkhaustov.tracker;

import ru.rkhaustov.tracker.dao.TrackerDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void execute(Input input, TrackerDao tracker) {
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
    private TrackerDao tracker;
    /**
     * @param actions array user action.
     */
    private List<UserAction> actions = new ArrayList<UserAction>();

    /**
     * Constructor class MenuTracker initialization.
     * @param input - select item.
     * @param tracker reference on tracker.
     */

    public MenuTracker(Input input, TrackerDao tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fillAction - fill action item.
     */
    public void fillAction() {
        this.actions.add(new AddItem());
        this.actions.add(new MenuTracker.ShowItems());
        this.actions.add(new EditItem());
        this.actions.add(this.new DeleteItem());
        this.actions.add(this.new FindId());
        this.actions.add(this.new FindName());
    }

    /**
     * Select action item.
     * @param key - item menu.
     */
    public  void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
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
     * @return select menu items.
     */
    public List<Integer> fillRange() {
        List<Integer> ranges = new ArrayList<Integer>();

        for (UserAction action : this.actions) {
            ranges.add(action.key());
        }
        return ranges;
    }

    /**
     * Inner class - 0. Add the new item.
     */
    private class AddItem extends BaseAction {
        /**
         * Construction string menu.
         */
        private AddItem() {
            super(0, "Add the new item");
        }

        /**
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, TrackerDao tracker) {
            String name = input.ask("Please, enter name: ");
            String desc = input.ask("Please, enter description: ");
            long created = new Date().getTime();
            System.out.println("id = " + tracker.add(new Item(name, desc, created)));
        }
    }

    /**
     * Inner class - Show all items.
     */
    private static class ShowItems extends BaseAction {
        /**
         *  Construction string menu.
         */
        private ShowItems() {
            super(1, "Show all items");
        }

        /**
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, TrackerDao tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(item);
            }
        }
    }
    /**
     * Inner class - Delete the item.
     */
    private class DeleteItem extends BaseAction {
        /**
         * Construction string menu.
         */
        private DeleteItem() {
            super(3, "Delete the item");
        }

        /**
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, TrackerDao tracker) {
            String id = input.ask("Please, enter id: ");
            tracker.delete(new Item(id, null, null, 0));
        }
    }
    /**
     * Inner class - Find item by Id.
     */
    private class FindId extends BaseAction {
        /**
         * Construction string menu.
         */
        private FindId() {
            super(4, "Find item by Id");
        }

        /**
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, TrackerDao tracker) {
            String id = input.ask("Please, enter id: ");
            System.out.println(tracker.findById(id));
        }
    }
    /**
     * Inner class - Find items by name.
     */
    private class  FindName extends BaseAction {
        /**
         * Construction string menu.
         */
        private FindName() {
            super(5, "Find items by name");
        }

        /**
         * @param input - select item.
         * @param tracker reference on tracker.
         */
        public void execute(Input input, TrackerDao tracker) {
            String name = input.ask("Please, enter name: ");
            for (Item item: tracker.findByName(name)) {
                System.out.println(item);
            }
        }
    }

}

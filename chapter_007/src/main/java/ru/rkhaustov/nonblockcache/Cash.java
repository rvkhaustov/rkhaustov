package ru.rkhaustov.nonblockcache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class Cash {
    /**
     * cash.
     */
    private Map<String, Model>  cash = new ConcurrentHashMap<>();

    /**
     * @param key key
     * @param model model
     */
    public void add(String key, Model model) {
        cash.putIfAbsent(key, model);
    }

    /**
     * @param key key
     */
    public void delete(String key) {
        cash.remove(key);
    }

    /**
     * @param key key
     * @param text text
     * @return text if error OptimisticException
     */
    public String update(String key, String text) {
        Model t = cash.computeIfPresent(key, (k, v) -> new Model(text, v.getVersion() + 1));

        if (t.getText().equals(text)) {
            return t.getText();
        } else {
            return "OptimisticException";
        }

    }

    /**
     * @param key key
     * @param text text
     * @return text
     */
    public String updateAndGet(String key, String text) {
        while (true) {
            Model current = cash.get(key);
            int version = current.getVersion();
            Model next = new Model(text, version + 1);
            if (cash.get(key).getVersion() == version) {
                cash.put(key, next);
                return text;
            }
        }
    }
}

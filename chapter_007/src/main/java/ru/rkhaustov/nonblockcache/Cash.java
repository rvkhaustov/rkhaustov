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
    private Map<String,Model>  cash = new ConcurrentHashMap<>();

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
        synchronized (cash.get(key).getVersion()) {
            Model current = cash.get(key);
            int version = current.getVersion();
            Model next = new Model(text, version + 1);
            if (cash.get(key).getVersion() == version) {
                cash.put(key, next);
                return text;
            } else {
                return "OptimisticException";
                //throw new OptimisticException("Race");
            }
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

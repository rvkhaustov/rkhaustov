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

        cash.computeIfPresent(key,
                (k, v) -> {
                    if (cash.get(k).getVersion() == v.getVersion()) {
                        return new Model(text, v.getVersion() + 1);
                    } else {
                        throw new OptimisticException("Error");
                    }
                });
        return text;
    }
}

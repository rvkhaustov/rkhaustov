package ru.rkhaustov.conversion;

import java.util.HashMap;
import java.util.List;
//import java.util.List;
//import java.util.HashMap;

/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class UserConvert {
    /**
     * @param list List list
     * @return HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
      HashMap<Integer, User> hashMap = new HashMap<Integer, User>();
        for (User user:list) {
            hashMap.put(user.getId(), user);
        }
      return hashMap;
    }
}

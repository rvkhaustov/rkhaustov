package ru.rkhaustov.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class SortUser {
    /**
     * @param list List
     * @return set TreeSet
     */
    public Set<User> sort(List<User> list) {
       Set<User> users = new TreeSet<User>();
       users.addAll(list);
       return users;
    }
}

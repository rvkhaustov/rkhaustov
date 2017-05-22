package ru.rkhaustov.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//import java.util.Arrays;


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

    /**
     * @param list List collection
     * @return sort on Hash
     */
    public List<User> sortHash(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return (o1.hashCode() > o2.hashCode()) ? 1 : (o1.hashCode() < o2.hashCode()) ? -1 : 0;
            }
        });
        return list;
    }

    /**
     * @param list List collection.
     * @return sort on length name User.
     */
    public List<User> sortLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.lengthName() > o2.lengthName() ? 1 : o1.lengthName() < o2.lengthName() ? -1 : 0;
            }
        });
        return list;
    }
}

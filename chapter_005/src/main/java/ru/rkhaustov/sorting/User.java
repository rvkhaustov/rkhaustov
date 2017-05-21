package ru.rkhaustov.sorting;

/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class User implements Comparable<User> {
    /**
     * name.
     */
    private String name;
    /**
     * age.
     */
    private int age;

    /**
     * @param name name
     * @param age age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @param o user
     * @return -1 0 1
     */
    @Override
    public int compareTo(User o) {
        return (this.age > o.age) ? 1 : (this.age < o.age) ? -1 : 0;
    }

}

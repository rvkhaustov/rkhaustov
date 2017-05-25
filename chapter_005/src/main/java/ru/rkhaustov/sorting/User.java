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
     * @return length name.
     */
    public int lengthName() {
        return this.name.length();
    }
    /**
     * @param o user
     * @return -1 0 1
     */
    @Override
    public int compareTo(User o) {
        return (this.age > o.age) ? 1 : (this.age < o.age) ? -1 : 0;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;

        if (age != user.age) {
            return false;
        }
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}

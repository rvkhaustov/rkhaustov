package ru.rkhaustov.map;

import java.util.Calendar;

/**
 * Created by rvkha_000 on 01.06.2017.
 */
public class User {
    /**
     * name.
     */
    private String name;
    /**
     * children.
     */
    private int children;
    /**
     * birthday.
     */
    private Calendar birthday;

    /**
     * @param name name
     * @param children children
     * @param birthday birthday
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


    /**
     * @return hash
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();

        return result;
    }

    /**
     * @param o object
     * @return false true
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }
}

package ru.rkhaustov.userstoreg;

/**
 * Created by rvkha_000 on 16.06.2017.
 */
public class User {
    /**
     * name.
     */
    private  String name;
    /**
     * passport.
     */
    private String passport;

    /**
     * @param name name
     * @param passport passport
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * @param o User
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

        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return String.format("name=%s, passport=%s", name, passport);
    }
}


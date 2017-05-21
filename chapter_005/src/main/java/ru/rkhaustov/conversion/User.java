package ru.rkhaustov.conversion;

/**
 * Created by rvkha_000 on 21.05.2017.
 */
public class User {
    /**
     * id.
     */
    private int id;
    /**
     * name.
     */
    private String name;
    /**
     * city.
     */
    private String city;

    /**
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param id id
     * @param name name
     * @param city city
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param o Object
     * @return true or false
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

        if (id != user.id) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return city != null ? city.equals(user.city) : user.city == null;
    }

    /**
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}

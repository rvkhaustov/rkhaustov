package ru.rkhaustov.bank;

/**
 * Created by rvkha_000 on 25.05.2017.
 */
public class Account {
    /**
     * value.
     */
    private double value = 0;

    /**
     * requisites.
     */
    private String requisites;

    /**
     * @param value set value
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @param requisites  requisites
     */
    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    /**
     * @return getvalue
     */
    public double getValue() {
        return value;
    }

    /**
     * @return getRequisites
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * @param requisites requisites
     * @param value value
     */
    public Account(String requisites, double value) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * @param requisites requisites
     */
    public Account(String requisites) {
        this.requisites = requisites;
    }

    /**
     * @return toString
     */
    @Override
    public String toString() {
        return String.format("requisites=%s, value=%s", requisites, value);
    }

    /**
     * @param o Account
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

        Account account = (Account) o;

        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;
    }

    /**
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return requisites != null ? requisites.hashCode() : 0;
    }
}

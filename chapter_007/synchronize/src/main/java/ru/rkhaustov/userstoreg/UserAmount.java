package ru.rkhaustov.userstoreg;

/**
 * Created by rvkha_000 on 19.06.2017.
 */
public class UserAmount {

    /**
     * amount.
     */
    private Float amount;

    /**
     * @param amount amount
     */
    public UserAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * @param value value
     * @return amount
     */
    public synchronized float changeAmount(float value) {
            amount += value;
            return amount;
    }
}

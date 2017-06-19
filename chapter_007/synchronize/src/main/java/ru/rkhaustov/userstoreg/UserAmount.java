package ru.rkhaustov.userstoreg;

/**
 * Created by rvkha_000 on 19.06.2017.
 */
public class UserAmount {

    private volatile Float amount;

    public UserAmount(Float amount) {
        this.amount = amount;
    }

    public float changeAmount(float value) {
        synchronized (amount) {
            amount +=value;
            return amount;
        }
    }
}

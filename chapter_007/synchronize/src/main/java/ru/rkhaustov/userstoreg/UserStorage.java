package ru.rkhaustov.userstoreg;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
//import java.util.List;

/**
 * Created by rvkha_000 on 19.06.2017.
 */
public class UserStorage {
    /**
     * userStorege.
     */
    private List<UserAmount> userStorege = new ArrayList<>();

    /**
     * @param userAmount userAmount
     */
    public void  add(UserAmount userAmount) {
        userStorege.add(userAmount);
    }


    /**
     * @param index index
     */
    public void remove(int index) {
        userStorege.remove(index);
    }

    /**
     * @param from from
     * @param to to
     * @param value value
     * @return amount
     */
    public float[] transferMoney(int from, int to, int value) {
        synchronized (userStorege) {
            return new float[]{userStorege.get(from).changeAmount(-value),
                    userStorege.get(to).changeAmount(value)};
        }
    }
}

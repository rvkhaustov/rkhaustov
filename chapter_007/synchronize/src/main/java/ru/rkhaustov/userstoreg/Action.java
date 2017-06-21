package ru.rkhaustov.userstoreg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;



/**
 * Created by rvkha_000 on 16.06.2017.
 */
public class Action {
    /**
     * Account.
     */
    private  Map<User, List<Account>> userAccount = new HashMap<>();

    /**
     * @return userAccount
     */
    public Map<User, List<Account>> getUserAccount() {
        return userAccount;
    }
    @Override
    public String toString() {
        return String.format("%s", userAccount);
    }
    /**
     * @param user User
     */
    public void addUser(User user) {
        List<Account> list = userAccount.get(user);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList<>());
            userAccount.put(user, list);
        }
    }
    /**
     * @param user User
     */
    public void deleteUser(User user) {
        userAccount.remove(user);
    }

    /**
     * @param user User
     * @param account Account
     */
    public void addAccountToUser(User user, Account account) {
        if (userAccount.get(user) != null) {
            Set<Account> accounts = new HashSet<>(userAccount.get(user));
            accounts.add(account);
            this.userAccount.put(user, new ArrayList<>(accounts));
        } else {
            this.userAccount.put(user, Arrays.asList(account));
        }

    }

    /**
     * @param user User
     * @param account Account
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (user != null && this.userAccount.containsKey(user)) {
            List<Account> accounts = userAccount.get(user);
            accounts.remove(account);
        }
    }

    /**
     * @param user User
     * @return List Account
     */
    public List<Account> getUserAccounts(User user) {
        return userAccount.get(user);
    }

    /**
     * @param user user
     * @param account account
     * @return amount account
     */
    public float getAccountAmount(final User user, final Account account) {
            for (Account accounts : userAccount.get(user)) {
                    if (accounts.getRequisites().equals(account.getRequisites())) {
                        return accounts.getAmount();
                    }
                }
            return -1;
    }

    /**
     * @param user user
     * @param account account
     * @param value amount
     */
    public void setAccountAmount(User user, Account account, float value) {
            for (Account accounts : userAccount.get(user)) {
                    if (accounts.getRequisites().equals(account.getRequisites())) {
                        accounts.setAmount(value);
                    }
            }
    }


    /**
     * @param srcUser srcUser
     * @param srcAccount srcAccount
     * @param dstUser dstUser
     * @param dstAccount dstAccount
     * @param amount amount
     * @return false / true
     */
    public float[] transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, float amount) {
        synchronized (userAccount) {
            float amountSrc = getAccountAmount(srcUser, srcAccount) - amount;
            float amountDst = getAccountAmount(dstUser, dstAccount);
            if (amountSrc >= 0 && amountDst >= 0) {
                setAccountAmount(srcUser, srcAccount, amountSrc);
                setAccountAmount(dstUser, dstAccount, amountDst + amount);
                return new float[]{amountSrc, amountDst + amount};
            }
            return new float[]{-1, -1};
        }
   }
}
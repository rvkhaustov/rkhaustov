package ru.rkhaustov.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


/**
 * Created by rvkha_000 on 25.05.2017.
 */
public class Action {
    /**
     * userAccount.
     */
    private Map<User, List<Account>> userAccount = new HashMap<>();

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
        userAccount.put(user, null);
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
     * @param srcUser srcUser
     * @param srcAccount srcAccount
     * @param dstUser dstUser
     * @param dstAccount dstAccount
     * @param amount amount
     * @return false / true
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        List<Account> srcList = new ArrayList<>(this.getUserAccounts(srcUser));
        List<Account> dstList = new ArrayList<>(this.getUserAccounts(dstUser));
        boolean correct = false;

        if (srcList != null && dstList != null
                && srcList.contains(srcAccount)
                && dstList.contains(dstAccount)) {
            for (Account account : srcList) {
                if (account.getRequisites().equals(srcAccount.getRequisites()) && account.getValue() >= amount) {
                    account.setValue(account.getValue() - amount);
                    for (Account accountDst : dstList) {
                        if (accountDst.getRequisites().equals(dstAccount.getRequisites())) {
                            accountDst.setValue(accountDst.getValue() + amount);
                        }
                    }
                    correct = true;
                    break;
                }
            }
        }
        return correct;
    }
}

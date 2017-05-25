package ru.rkhaustov.bank;

//import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;


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
//        return String.format("userAccount=%s", userAccount);

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
            List<Account> list = new ArrayList<>();
            list.add(account);
            this.userAccount.put(user, list);
        }

    }

    /**
     * @param user User
     * @param account Account
     */
    public void deleteAccountFromUser(User user, Account account) {
        if (userAccount.get(user) != null) {
            List<Account> accounts = new ArrayList<>(userAccount.get(user));
            accounts.remove(account);
            this.userAccount.put(user, new ArrayList<>(accounts));
        }
    }

    /**
     * @param user User
     * @return List Account
     */
    public List<Account> getUserAccounts(User user) {
        if (userAccount.get(user) != null) {
            List<Account> accounts = new ArrayList<>(userAccount.get(user));
            return accounts;
        }
        return null;
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

//    public static void main(String[] args) {
//        Action action = new Action();
//        User user = new User("Igor", "1234567");
//        action.addUser(new User("Igor", "1234567"));
//        action.addAccountToUser(new User("Igor", "1234567")
//                ,new Account("1111111111", 100));
//        action.addAccountToUser(new User("Igor", "1234567")
//                ,new Account("222222", 0));
//        action.addAccountToUser(new User("Igor", "1234567")
//                ,new Account("11111111112", 0));
//
//        User userDima = new User("Dima", "7654321");
//
//        action.addUser(new User("Dima", "7654321"));
//        action.addAccountToUser(new User("Dima", "7654321")
//                ,new Account("D1111111111", 0));
//        action.addAccountToUser(new User("Dima", "7654321")
//                ,new Account("D222222", 0));
//        action.addAccountToUser(new User("Dima", "7654321")
//                ,new Account("D11111111112", 0));
//
//        //        action.deleteUser(new User("Igor", "1234567"));
////        for (Map.Entry<User,List<Account>> entry : action.userAccount.entrySet()) {
////            System.out.println(entry.getKey() + " " + entry.getValue() );
////        }
////        System.out.println("deleteAccountFromUser");
////        action.deleteAccountFromUser(new User("Dima", "7654321"), new Account("D1111111111", 10));
////
////        System.out.println(action.getUserAccounts(new User("Igor", "1234567")));
//
////        System.out.println(action.userAccount.toString());
//
//
//
////        action.deleteUser(new User("Igor", "1234567"));
////        System.out.println(action.userAccount.toString());
//        System.out.println("befor");
//        for (Map.Entry<User,List<Account>> entry : action.userAccount.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue() );
//        }
//
//        System.out.println(action.transferMoney(user
//                , new Account("1111111111")
//                ,userDima
//                , new Account("D222222"), 100));
//        System.out.println("after");
//        for (Map.Entry<User,List<Account>> entry : action.userAccount.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue() );
//        }
////        for( Map.Entry<String, String> entry : map.entrySet() ){
////            System.out.println( entry.getKey() + " " + entry.getValue() );
////        }
////        Action.this.addUser(new User("Igor", "1234567"));
//    }
}

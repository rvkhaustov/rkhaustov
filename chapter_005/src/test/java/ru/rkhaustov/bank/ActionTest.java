package ru.rkhaustov.bank;

import org.junit.Test;

//import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Created by rvkha_000 on 26.05.2017.
 */
public class ActionTest {
    /**
     * Test addUser.
     */
    @Test
    public void whenAddUserThenSaveUserInMap() {
        Action action = new Action();
        Map<User, List<Account>> expected = new HashMap<>();
        User user = new User("Igor", "1234567");
        action.addUser(user);
        expected.put(user, null);
        assertThat(action.getUserAccount(), is(expected));
    }
    /**
     * Test deleteUser.
     */
    @Test
    public void whenDeleteUserThenDeleteUserFromMap() {
        Action action = new Action();
        Map<User, List<Account>> expected = new HashMap<>();

        User user = new User("Igor", "1234567");
        action.addUser(user);

        user = new User("Dima", "7654321");
        action.addUser(user);
        action.deleteUser(new User("Igor", "1234567"));

        expected.put(user, null);

        assertThat(action.getUserAccount(), is(expected));
    }
    /**
     * Test addAccountToUser.
     */
    @Test
    public void whenAddAccountToUserThenAddAccountToUserInMap() {
        Action action = new Action();
        Map<User, List<Account>> expected = new HashMap<>();
        Set<Account> accountsExpected = new HashSet<>();

        User user = new User("Igor", "1234567");
        action.addUser(user);

        Account account = new Account("1111111111");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        account = new Account("3333333333");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        account = new Account("2222222222");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);



        expected.put(user, new ArrayList<>(accountsExpected));

        assertThat(action.getUserAccount(), is(expected));
    }
    /**
     * Test deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUserThenDeleteAccountFromUserInMap() {
        Action action = new Action();
        Map<User, List<Account>> expected = new HashMap<>();
        Set<Account> accountsExpected = new HashSet<>();

        User user = new User("Igor", "1234567");
        action.addUser(user);

        Account account = new Account("1111111111");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        account = new Account("3333333333");
        action.addAccountToUser(user, account);


        account = new Account("2222222222");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        expected.put(user, new ArrayList<>(accountsExpected));
        action.deleteAccountFromUser(user, new Account("3333333333"));
        assertThat(action.getUserAccount(), is(expected));
    }
    /**
     * Test transferMoney .
     */
    @Test
    public void whenTransferMoneyFromUserThendeleteAccountFromUserInMap() {
        Action action = new Action();
        Map<User, List<Account>> expected = new HashMap<>();
        Set<Account> accountsExpected = new HashSet<>();

        User userIgor = new User("Igor", "1234567");
        action.addUser(userIgor);

        Account account = new Account("I1111111111", 100);
        action.addAccountToUser(userIgor, account);
        accountsExpected.add(account);

        account = new Account("I3333333333");
        action.addAccountToUser(userIgor, account);

        User userDima = new User("Dima", "7654321");
        action.addUser(userDima);

        account = new Account("D1111111111");
        action.addAccountToUser(userDima, account);

        account = new Account("D3333333333");
        action.addAccountToUser(userDima, account);


        accountsExpected.add(account);

        expected.put(userIgor, new ArrayList<>(Arrays.asList(
                new Account("I1111111111", 60),
                new Account("I3333333333"))));

        expected.put(userDima, new ArrayList<>(Arrays.asList(
                new Account("D1111111111", 40),
                new Account("D3333333333"))));

        action.transferMoney(userIgor,
                new Account("I1111111111"),
                userDima,
                new Account("D3333333333"),
                40);
        assertThat(action.getUserAccount(), is(expected));
    }
    /**
     * Test getUserAccounts.
     */
    @Test
    public void whenGetUserAccountsThenListAccount() {
        Action action = new Action();
        Set<Account> accountsExpected = new HashSet<>();

        User user = new User("Igor", "1234567");
        System.out.println(action.getUserAccounts(null));
        action.addUser(user);

        Account account = new Account("1111111111");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        account = new Account("3333333333");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);

        account = new Account("2222222222");
        action.addAccountToUser(user, account);
        accountsExpected.add(account);



        List<Account> expected = new ArrayList<>(accountsExpected);

        assertThat(action.getUserAccounts(user), is(expected));
    }

}
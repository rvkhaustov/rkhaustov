package ru.rkhaustov.IoC;

import ru.rkhaustov.bank.Account;
import ru.rkhaustov.bank.User;

import java.io.File;

/**
 * Created by rvkha_000 on 23.09.2017.
 */
public class Testt {
    private User user;
    Account account;
    public Testt() {
        this.account = new Account("dd");
        this.user = new User("111","222");
    }

    public static void main(String[] args) {
      Testt testt = new Testt();
        System.out.println(testt.user.toString());
        System.out.println(testt.account.toString());

        File fl = new File("c:/other/222.txt");

    }
}

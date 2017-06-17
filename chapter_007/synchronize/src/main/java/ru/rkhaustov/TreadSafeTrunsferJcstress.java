package ru.rkhaustov;


import ru.rkhaustov.userstoreg.Account;
import ru.rkhaustov.userstoreg.User;
import ru.rkhaustov.userstoreg.Action;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.State;

import org.openjdk.jcstress.infra.results.FloatResult3;

//import java.util.*;
/*
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferMoney
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferMoney
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferMoney
(ETA:        now) (Rate: 5,62E+05 samples/sec) (Tests: 1 of 1) (Forks:  6 of 6) (Iterations: 30 of 30; 30 passed, 0 failed, 0 soft errs, 0 hard errs)


 */

/**
 * Created by rvkha_000 on 16.06.2017.
 */
public class TreadSafeTrunsferJcstress {
    /**
     * StateAction.
     */
    @State
    public static class StateAction {
        /**
         * action.
         */
        private Action action;

        /**
         * @return action.
         */
        public Action getAction() {
            return action;
        }

        /**
         * Constructor.
         */
        public StateAction() {
            action = new Action();
            User userIgor = new User("Igor", "1234567");
            action.addUser(userIgor);

            Account account = new Account("I1111111111", 500);
            action.addAccountToUser(userIgor, account);

            User userDima = new User("Dima", "7654321");
            action.addUser(userDima);

            account = new Account("D1111111111", 0);
            action.addAccountToUser(userDima, account);

            account = new Account("D2222222222", 200);
            action.addAccountToUser(userDima, account);
        }
    }

    /**
     * Test transfer money.
     */
    @JCStressTest
    @Outcome(id = "440.0, 240.0, 20.0", expect = Expect.ACCEPTABLE, desc = "ThreadSafe money transfer")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe money transfer")
    public static class  TransferMoney {
        /**
         * @param stateAction stateAction
         */
        @Actor
        public void firstTransferMoney(StateAction stateAction)  {


            stateAction.action.transferMoney(new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    new User("Dima", "7654321"),
                    new Account("D2222222222"),
                    40);
        }

        /**
         * @param stateAction stateAction
         */
        @Actor
        public void secondTransferMoney(StateAction stateAction) {
            stateAction.action.transferMoney(new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    new User("Dima", "7654321"),
                    new Account("D1111111111"),
                    20);
        }

        /**
         * @param stateAction stateAction
         * @param result3 result3
         */
        @Arbiter
        public void getAmount(StateAction stateAction, FloatResult3 result3) {
            result3.r1 = stateAction.action.getUserAccount().get(new User("Igor", "1234567")).get(0).getValue();
            result3.r2 = stateAction.action.getUserAccount().get(new User("Dima", "7654321")).get(0).getValue();
            result3.r3 = stateAction.action.getUserAccount().get(new User("Dima", "7654321")).get(1).getValue();
        }
    }
}

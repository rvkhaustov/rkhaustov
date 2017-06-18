package ru.rkhaustov;


import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.annotations.Description;
import ru.rkhaustov.userstoreg.Account;
import ru.rkhaustov.userstoreg.User;
import ru.rkhaustov.userstoreg.Action;

import org.openjdk.jcstress.infra.results.FloatResult3;
import org.openjdk.jcstress.infra.results.FloatResult4;

/*
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferAccountFirstToSecondAndSecondToFirst
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferAccountFirstToSecondAndFirstToThird
      [OK] ru.rkhaustov.TreadSafeTrunsferJcstress.TransferAccountFirstToSecondAndFirstToThirdTotal
(ETA:        now) (Rate: 5,09E+05 samples/sec) (Tests: 3 of 3) (Forks: 18 of 18) (Iterations: 90 of 90; 90 passed, 0 failed, 0 soft errs, 0 hard errs)
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
     * Test transfer firstAccount to secondAccont and secondAccont to firstAccount.
     */
    @JCStressTest
    @Description("Test transfer firstAccount to secondAccont and secondAccont to firstAccount")
    @Outcome(id = "460.0, 240.0, 495.0, 205.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, firstTransferMoney, then secondTransferMoney")
    @Outcome(id = "495.0, 205.0, 535.0, 165.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, secondTransferMoney, then firstTransferMoney")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe money transfer")
    public static class  TransferAccountFirstToSecondAndSecondToFirst {
        /**
         * @param stateAction stateAction
         * @param result4 result4
         */
        @Actor
        public void firstTransferMoney(StateAction stateAction, FloatResult4 result4)  {
            final float[] result;
            result = stateAction.action.transferMoney(new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    new User("Dima", "7654321"),
                    new Account("D2222222222"),
                    40);
            result4.r1 = result[0];
            result4.r2 = result[1];
        }

        /**
         * @param stateAction stateAction
         * @param result4 result4
         */
        @Actor
        public void secondTransferMoney(StateAction stateAction, FloatResult4 result4) {
            final float[] result;
            result = stateAction.action.transferMoney(new User("Dima", "7654321"),
                    new Account("D2222222222"),
                    new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    35);
            result4.r3 = result[1];
            result4.r4 = result[0];
        }
    }


    /**
     * Test transfer firstAccount to secondAccount and firstAccount to ThirdAccount.
     */
    @JCStressTest
    @Description("Test transfer firstAccount to secondAccount and firstAccount to ThirdAccount")
    @Outcome(id = "460.0, 240.0, 440.0, 20.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, firstTransferMoney, then secondTransferMoney")
    @Outcome(id = "440.0, 240.0, 480.0, 20.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, secondTransferMoney, then firstTransferMoney")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe money transfer")
    public static class  TransferAccountFirstToSecondAndFirstToThird {
        /**
         * @param stateAction stateAction
         * @param result4 result4
         */
        @Actor
        public void firstTransferMoney(StateAction stateAction, FloatResult4 result4)  {
            final float[] result;
            result = stateAction.action.transferMoney(new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    new User("Dima", "7654321"),
                    new Account("D2222222222"),
                    40);
            result4.r1 = result[0];
            result4.r2 = result[1];
        }

        /**
         * @param stateAction stateAction
         * @param result4 result4
         */
        @Actor
        public void secondTransferMoney(StateAction stateAction, FloatResult4 result4) {
            final float[] result;
            result = stateAction.action.transferMoney(new User("Igor", "1234567"),
                    new Account("I1111111111"),
                    new User("Dima", "7654321"),
                    new Account("D1111111111"),
                    20);

            result4.r3 = result[0];
            result4.r4 = result[1];
        }

    }


    /**
     * Test total transfer firstAccount to secondAccount and firstAccount to ThirdAccount.
     */
    @JCStressTest
    @Description("Test total transfer firstAccount to secondAccont and firstAccount to ThirdAccount")
    @Outcome(id = "440.0, 20.0, 240.0", expect = Expect.ACCEPTABLE, desc = "ThreadSafe money transfer")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe money transfer")
    public static class  TransferAccountFirstToSecondAndFirstToThirdTotal {
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
        public void secondTransferMoney1(StateAction stateAction) {
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
            result3.r1 = stateAction.action.getAccountAmount(new User("Igor", "1234567"),
                    new Account("I1111111111"));
            result3.r2 = stateAction.action.getAccountAmount(new User("Dima", "7654321"),
                    new Account("D1111111111"));
            result3.r3 = stateAction.action.getAccountAmount(new User("Dima", "7654321"),
                    new Account("D2222222222"));
        }
    }
}

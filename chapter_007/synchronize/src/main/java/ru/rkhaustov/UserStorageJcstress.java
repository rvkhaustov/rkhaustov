package ru.rkhaustov;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.FloatResult3;
import org.openjdk.jcstress.infra.results.FloatResult4;
import ru.rkhaustov.userstoreg.UserAmount;
import ru.rkhaustov.userstoreg.UserStorage;
/*
      [OK] ru.rkhaustov.UserStorageJcstress.TransferAccountFirstToSecondAndSecondToFirst
      [OK] ru.rkhaustov.UserStorageJcstress.TransferAccountFirstToSecondAndSecondToFirst
(ETA:        now) (Rate: 1,87E+06 samples/sec) (Tests: 1 of 1) (Forks:  6 of 6) (Iterations: 30 of 30; 30 passed, 0 failed, 0 soft errs, 0 hard errs)


 */
/**
 * Created by rvkha_000 on 19.06.2017.
 */
public class UserStorageJcstress {
    /**
     * StateAction.
     */
    @State
    public static class StateAction {
        /**
         * action.
         */
        private UserStorage userStorage;

//        /**
//         * @return action.
//         */
//        public Action getAction() {
//            return action;
//        }

        /**
         * Constructor.
         */
        public StateAction() {
            userStorage = new UserStorage();

            userStorage.add(new UserAmount(100f));
            userStorage.add(new UserAmount( 200f));
        }
    }

    /**
     * Test transfer firstAccount to secondAccont and secondAccont to firstAccount.
     */
    @JCStressTest
    @Description("Test transfer firstAccount to secondAccont and secondAccont to firstAccount")
    @Outcome(id = "60.0, 240.0, 90.0, 210.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, firstTransferMoney, then secondTransferMoney")
    @Outcome(id = "90.0, 210.0, 130.0, 170.0", expect = Expect.ACCEPTABLE, desc = "ThreadNoSafe money transfer, secondTransferMoney, then firstTransferMoney")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe money transfer")
    public static class  TransferAccountFirstToSecondAndSecondToFirst {
        /**
         * @param stateAction stateAction
         * @param result4 result4
         */
        @Actor
        public void firstTransferMoney(StateAction stateAction, FloatResult4 result4)  {
            final float[] result;
            result = stateAction.userStorage.transferMoney(0, 1,40);
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
            result = stateAction.userStorage.transferMoney(1, 0,30);
            result4.r3 = result[1];
            result4.r4 = result[0];
        }
    }
}


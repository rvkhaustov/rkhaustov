package ru.rkhaustov;

/**
 * Created by rvkha_000 on 15.06.2017.
 */

import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.Actor;


import org.openjdk.jcstress.infra.results.LongResult2;



/*
     [OK] ru.rkhaustov.IncrementTestJcstress.AddVariable
      [OK] ru.rkhaustov.IncrementTestJcstress.AddVariable
      [OK] ru.rkhaustov.IncrementTestJcstress.AddVariable
      [OK] ru.rkhaustov.IncrementTestJcstress.AddVariable
(ETA:        now) (Rate: 4,15E+06 samples/sec) (Tests: 1 of 1) (Forks:  6 of 6) (Iterations: 30 of 30; 30 passed, 0 failed, 0 soft errs, 0 hard errs)


*/

/**
 * Library Jcstress Test.
 */
public class IncrementTestJcstress {
    /**
     * First method.
     * State Variable.
     */
//    private Count.Counter counter = new Count.Counter();
    @State
    public static class StateVariable {
        /**
         * variable.
         */

        private final Count.Counter counter = new Count.Counter();


    }
    /**
     * SJCStressTest.
     */
    @JCStressTest
    @Outcome(id = "1, 2", expect = Expect.ACCEPTABLE, desc = "actor1 incremented, then actor2.")
    @Outcome(id = "2, 1", expect = Expect.ACCEPTABLE, desc = "actor2 incremented, then actor1.")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Case violating atomicity.")

    /**
     * Add Variable.
     */
//    @State
    public static class  AddVariable  {
        /**
         * Actor 1.
         * @param stateVariable stateVariable.
         * @param result2 result2.
         */
        @Actor
        public void actor1(StateVariable stateVariable, LongResult2 result2)  {
            result2.r1 = stateVariable.counter.incrementFirstMethod();
//            result2.r1 = stateVariable.counter.incrementSecondMethod();
//            result2.r1 = stateVariable.counter.incrementThirdMethod();
//            synchronized (stateVariable.counter) {
//                result2.r1 = stateVariable.counter.incrementForthMethod();
//            }
        }
        /**
         * Actor 2.
         * @param stateVariable StateVariable
         * @param result2 IntResult2
         */
        @Actor
        public void actor2(StateVariable stateVariable, LongResult2 result2) {
            result2.r2 = stateVariable.counter.incrementFirstMethod();
//            result2.r2 = stateVariable.counter.incrementSecondMethod();
//            result2.r2 = stateVariable.counter.incrementThirdMethod();
//            synchronized (stateVariable.counter) {
//                result2.r2 = stateVariable.counter.incrementForthMethod();
//            }
        }
    }
}


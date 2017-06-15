package ru.rkhaustov.jmm;

import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.Actor;


import org.openjdk.jcstress.infra.results.IntResult2;

/*
   [FAILED] ru.rkhaustov.jmm.LibraryJcstressTest.AddVariable
    (JVM args: [-client])
  Observed state   Occurrences   Expectation  Interpretation
            0, 0        10а521     FORBIDDEN  Both actors Did not enter the method.
            0, 1         1а048     FORBIDDEN  actor1 incremented, actor2 no incremented
            1, 0         1а031     FORBIDDEN  actor2 incremented, actor1 no incremented
            1, 1             0     FORBIDDEN  Both actors came up with the same value: atomicity failure.
            1, 2             0    ACCEPTABLE  actor1 incremented, then actor2.
            2, 1             0    ACCEPTABLE  actor2 incremented, then actor1.

  [FAILED] ru.rkhaustov.jmm.LibraryJcstressTest.AddVariable
    (JVM args: [-XX:TieredStopAtLevel=1])
  Observed state   Occurrences   Expectation  Interpretation
            0, 0         9а509     FORBIDDEN  Both actors Did not enter the method.
            0, 1           627     FORBIDDEN  actor1 incremented, actor2 no incremented
            1, 0           604     FORBIDDEN  actor2 incremented, actor1 no incremented
            1, 1             0     FORBIDDEN  Both actors came up with the same value: atomicity failure.
            1, 2             0    ACCEPTABLE  actor1 incremented, then actor2.
            2, 1             0    ACCEPTABLE  actor2 incremented, then actor1.

*/

/**
 * Library Jcstress Test.
 */
public class LibraryJcstressTest {
    /**
     * State Variable.
     */
    @State
    public static class StateVariable {
        /**
         * variable.
         */
        private Variable variable = new Variable(0);

        /**
         * Thread First.
         */
        private Thread threadFirst =  new Thread(new Runnable() {
            @Override
            public void run() {
                variable.add();
            }
        });
        /**
         * Thread Second.
         */
        private Thread threadSecond =  new Thread(new Runnable() {
            @Override
            public void run() {
                variable.add();
            }
        });

    }
    /**
     * SJCStressTest.
     */
    @JCStressTest
    @Outcome(id = "0, 0", expect = Expect.FORBIDDEN, desc = "Both actors Did not enter the method.")
    @Outcome(id = "1, 1", expect = Expect.FORBIDDEN, desc = "Both actors came up with the same value: atomicity failure.")
    @Outcome(id = "0, 1", expect = Expect.FORBIDDEN, desc = "actor1 incremented, actor2 no incremented")
    @Outcome(id = "1, 0", expect = Expect.FORBIDDEN, desc = "actor2 incremented, actor1 no incremented")
    @Outcome(id = "1, 2", expect = Expect.ACCEPTABLE, desc = "actor1 incremented, then actor2.")
    @Outcome(id = "2, 1", expect = Expect.ACCEPTABLE, desc = "actor2 incremented, then actor1.")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Case violating atomicity.")

    /**
     * Add Variable.
     */
    public static class AddVariable {
        /**
         * Actor 1.
         * @param stateVariable stateVariable.
         * @param result2 result2.
         */
       @Actor
        public void actor1(StateVariable stateVariable, IntResult2 result2) {

            stateVariable.threadFirst.start();
            result2.r1 = stateVariable.variable.getVariable();
        }
        /**
         * Actor 2.
         * @param stateVariable StateVariable
         * @param r IntResult2
         */
        @Actor
        public void actor2(StateVariable stateVariable, IntResult2 r) {
            stateVariable.threadSecond.start();
            r.r2 = stateVariable.variable.getVariable();
        }
    }
}

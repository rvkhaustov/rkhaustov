package ru.rkhaustov.nonblockcache;

import org.openjdk.jcstress.annotations.*;
import org.openjdk.jcstress.infra.results.StringResult2;


/*
           Observed state   Occurrences       Expectation  Interpretation
                  111, 222     8а662а078        ACCEPTABLE  Non-blocking cache
  111, OptimisticException        98а130   ACCEPTABLE_SPEC  Race
  OptimisticException, 222       141а842   ACCEPTABLE_SPEC  Race

 */

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class CashJcstress {
    /**
     * CashState.
     */
    @State
    public static class CashState {
        /**
         * action.
         */
        private Cash cash;

        /**
         * Constructor.
         */
        public CashState() {
            cash = new Cash();
            cash.add("task_1", new Model("000", 0));
        }
    }
    /**
     * Test Non-blocking cache.
     */
    @JCStressTest
    @Description("Test Non-blocking cache - update")
    @Outcome(id = "111, 222", expect = Expect.ACCEPTABLE, desc = "Non-blocking cache")
    @Outcome(id = "111, OptimisticException", expect = Expect.ACCEPTABLE_SPEC, desc = "Race")
    @Outcome(id = "OptimisticException, 222", expect = Expect.ACCEPTABLE_SPEC, desc = "Race")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Error")
    public static class  nonBlockingCacheUpdate {
        /**
         * @param cashState cashState
         * @param result2 result4
         */
        @Actor
        public void firstUpdate(CashState cashState, StringResult2 result2)  {
            result2.r1 = cashState.cash.update("task_1", "111");
        }
        /**
         * @param cashState cashState
         * @param result2 result4
         */
        @Actor
        public void secondUpdate(CashState cashState, StringResult2 result2) {
            result2.r2 = cashState.cash.update("task_1", "222");
        }
    }
/*
     [OK] ru.rkhaustov.nonblockcache.CashJcstress.nonBlockingCacheUpdateAndGetTest
      [OK] ru.rkhaustov.nonblockcache.CashJcstress.nonBlockingCacheUpdateAndGetTest
      [OK] ru.rkhaustov.nonblockcache.CashJcstress.nonBlockingCacheUpdateAndGetTest
      [OK] ru.rkhaustov.nonblockcache.CashJcstress.nonBlockingCacheUpdateAndGetTest

 */

    /**
     * Test Non-blocking cache updateAndGetTest.
     */
    @JCStressTest
    @Description("Test Non-blocking cache - updateAndGetTest")
    @Outcome(id = "111, 222", expect = Expect.ACCEPTABLE, desc = "Non-blocking cache")
    @Outcome(id = "111, OptimisticException", expect = Expect.ACCEPTABLE_SPEC, desc = "Race")
    @Outcome(id = "OptimisticException, 222", expect = Expect.ACCEPTABLE_SPEC, desc = "Race")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Error")
    public static class  nonBlockingCacheUpdateAndGetTest {
        /**
         * @param cashState cashState
         * @param result2 result4
         */
        @Actor
        public void firstUpdate(CashState cashState, StringResult2 result2)  {
            result2.r1 = cashState.cash.updateAndGet("task_1", "111");
        }
        /**
         * @param cashState cashState
         * @param result2 result4
         */
        @Actor
        public void secondUpdate(CashState cashState, StringResult2 result2) {
            result2.r2 = cashState.cash.updateAndGet("task_1", "222");
        }
    }
}



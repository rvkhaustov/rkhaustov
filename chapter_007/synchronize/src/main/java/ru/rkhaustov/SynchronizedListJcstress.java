package ru.rkhaustov;


import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.Arbiter;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.infra.results.IntResult2;
import org.openjdk.jcstress.infra.results.IntResult1;
import ru.rkhaustov.list.DynamicListSynch;
//import ru.rkhaustov.list.LinkedArraySynch;
import ru.rkhaustov.list.SynchronizedList;

/*
      [OK] ru.rkhaustov.SynchronizedListJcstress.SynchronizedListAddGetTest
      [OK] ru.rkhaustov.SynchronizedListJcstress.SynchronizedListAddGetTest
      [OK] ru.rkhaustov.SynchronizedListJcstress.SynchronizedListAddGetTest
      [OK] ru.rkhaustov.SynchronizedListJcstress.SynchronizedListAddGetTest
(ETA:        now) (Rate: 3,84E+06 samples/sec) (Tests: 2 of 2) (Forks: 12 of 12) (Iterations: 60 of 60; 60 passed, 0 failed, 0 soft errs, 0 hard errs)


 */

/**
 * Created by rvkha_000 on 17.06.2017.
 */
public class SynchronizedListJcstress {

    /**
     * SynchronizedListState.
     */
    @State
    public static class SynchronizedListState {
        /**
         * SynchronizedList.
         */
        private SynchronizedList<Integer> synchronizedList = new DynamicListSynch(2);
//        private SynchronizedList<Integer> synchronizedList = new LinkedArraySynch<>();
    }

    /**
     * SynchronizedListAddGetTest.
     */
    @JCStressTest
    @Description("Test ThreadSafe method add and get SynchronizedList.")
    @Outcome(id = "0, 1", expect = Expect.ACCEPTABLE, desc = "First add 0 and second add 1")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Case violating ThreadSafe.")
    public static class SynchronizedListAddGetTest {

        /**
         * @param state state
         * @param result2  result2
         */
        @Actor
        public void thread1(SynchronizedListState state, IntResult2 result2) {

            int index = state.synchronizedList.add(0);
            Integer value = state.synchronizedList.get(index);
            result2.r1 = (value == null ? -1 : value);

        }
        /**
         * @param state state
         * @param result2  result2
         */
        @Actor
        public void thread2(SynchronizedListState state, IntResult2 result2) {
            int index = state.synchronizedList.add(1);
            Integer value = state.synchronizedList.get(index);
            result2.r2 = (value == null ? -1 : value);
        }
    }

    /**
     * SynchronizedListSizeTest.
     */
    @JCStressTest
    @Description("Test race map check size")
    @Outcome(id = "2", expect = Expect.ACCEPTABLE, desc = "Size of SynchronizedList = 2 ")
    @Outcome(expect = Expect.FORBIDDEN, desc = "Case violating ThreadSafe.")
    public static class SynchronizedListSizeTest {

        /**
         * @param state state
         */
        @Actor
        public void thread1(SynchronizedListState state) {
            state.synchronizedList.add(0); // .map.put("A", 0);
        }

        /**
         * @param state state
         */
        @Actor
        public void thread2(SynchronizedListState state) {
            state.synchronizedList.add(1); // .map.put("A", 0);
        }

        /**
         * @param state state
         * @param result1 result1
         */
        @Arbiter
        public void arbiter(SynchronizedListState state, IntResult1 result1) {
            result1.r1 = state.synchronizedList.size();
        }
    }

}
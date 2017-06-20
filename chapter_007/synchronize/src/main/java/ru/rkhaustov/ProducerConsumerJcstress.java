package ru.rkhaustov;

import org.openjdk.jcstress.annotations.Actor;
import org.openjdk.jcstress.annotations.JCStressTest;
import org.openjdk.jcstress.annotations.Outcome;
import org.openjdk.jcstress.annotations.Expect;
import org.openjdk.jcstress.annotations.State;
import org.openjdk.jcstress.annotations.Description;
import org.openjdk.jcstress.infra.results.IntResult2;
import ru.rkhaustov.producerconsumer.ProducerConsumer;

/*
      [OK] ru.rkhaustov.ProducerConsumerJcstress.ProducerConsumerAddGetTest
      [OK] ru.rkhaustov.ProducerConsumerJcstress.ProducerConsumerAddGetTest
(ETA:        now) (Rate: 2,40E+06 samples/sec) (Tests: 1 of 1) (Forks:  6 of 6) (Iterations: 30 of 30; 30 passed, 0 failed, 0 soft errs, 0 hard errs)

 */
/**
 * Created by rvkha_000 on 20.06.2017.
 */
public class ProducerConsumerJcstress {

    /**
     * SynchronizedListState.
     */
    @State
    public static class ProducerConsumerState {
        /**
         * SynchronizedList.
         */
        private volatile ProducerConsumer<Integer> producerConsumer = new ProducerConsumer();
    }

    /**
     * ProducerConsumerAddGetTest.
     */
    @JCStressTest
    @Description("Test Producer Consumer context switch")
    @Outcome(id = "0, -1", expect = Expect.ACCEPTABLE, desc = "Ok")
    @Outcome(id = "0, 0", expect = Expect.ACCEPTABLE, desc = "Ok")
    @Outcome(expect = Expect.FORBIDDEN, desc = "ThreadNoSafe.")
    public static class ProducerConsumerAddGetTest {

        /**
         * @param state state
         */
        @Actor
        public void thread1(ProducerConsumerState state) {
            state.producerConsumer.add(0);
        }
        /**
         * @param state   state
         * @param result2 result2
         */
        @Actor
        public void thread2(ProducerConsumerState state, IntResult2 result2) {
            Integer result = state.producerConsumer.get();
            result2.r1 = (result == null ? -1 : result);
        }
        /**
         * @param state   state
         * @param result2 result2
         */
        @Actor
        public void thread3(ProducerConsumerState state, IntResult2 result2) {
            Integer result = state.producerConsumer.getObject();
            result2.r2 = (result == null ? -1 : result);
        }
    }
}

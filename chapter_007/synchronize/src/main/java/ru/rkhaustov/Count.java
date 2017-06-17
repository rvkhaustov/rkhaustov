package ru.rkhaustov;

/**
 * Created by rvkha_000 on 15.06.2017.
 */
public class Count {

    /**
     * Counter.
     */
    public static final class Counter {
        /**
         * count.
         */
        private volatile long count = 0L;
        /**
         * static long count.
         */
        private  static long countStatic = 0L;
        /**
         * lock.
         */
        private Object lock = new Object();

        /**
         * @return
         */
        /**
         * First Method.
         * @return count.
         */
        public synchronized long incrementFirstMethod() {
            return ++count;
        }

        /**
         * Second Method.
         * @return count.
         */
        public long incrementSecondMethod() {
            synchronized (this) {
                return ++this.count;
            }
        }

        /**
         * Third Method.
         * @return count.
         */
        public static synchronized long incrementThirdMethod() {
            return ++countStatic;
        }

        /**
         * Forth Method.
         * @return count.
         */
        public long incrementForthMethod() {
            synchronized (this.lock) {
                return ++this.count;
            }
        }
    }
}

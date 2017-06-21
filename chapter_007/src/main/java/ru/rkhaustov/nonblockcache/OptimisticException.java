package ru.rkhaustov.nonblockcache;

/**
 * Created by rvkha_000 on 21.06.2017.
 */
public class OptimisticException extends RuntimeException {
            /**
         *
         * @param msg - text message.
         */
        public OptimisticException(String msg) {
            super(msg);
        }
}

package ru.job4j.loop;

/**
 * @author rkhaustov
 * @version 1
 * @since 04.2017
 */
public class Counter {
    /**
    * Method add.
    * @param start - start
    * @param finish - finish
    * @return count
    */
        public int add(int start, int finish) {
        int count = 0;
        for (int index = start; index <= finish; index++) {
            count  = count + ((index % 2 == 0) ? index : 0);
        }
            return count;
    }
}
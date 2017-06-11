package ru.rkhaustov.orderbook;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
 * Created by rvkha_000 on 11.06.2017.
 */
public class OrderBookTest {
    /**
     * Method readXML(fileName).
     * Method outputOrderBook.
     */
    @Test
    public void whenReadXmlThenLoadBidAsk() {
         final String fileName = "orders.xml";
        OrderBook orderBook = new OrderBook();

        long startTime = System.currentTimeMillis();

        orderBook.readXML(fileName);

        long firstTime = System.currentTimeMillis();

        orderBook.outputOrderBook();

        long secondTime = System.currentTimeMillis();

        System.out.println(String.format("Time load xml: %s sec.", (float) (firstTime - startTime) / 1000));
        System.out.println(String.format("Time output  : %s sec.", (float) (secondTime - firstTime) / 1000));
        System.out.println(String.format("All time     : %s sec.", (float) (secondTime - startTime) / 1000));
        assertThat((double) (secondTime - startTime) / 1000, closeTo(5.0, 1.0));
    }

}
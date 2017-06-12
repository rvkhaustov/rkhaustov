package ru.rkhaustov.orderbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
//import java.util.Collections;
//import java.util.TreeMap;
//import java.util.Map;
//import java.util.HashMap;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashMap;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *  create Order Books according to orders from XML file.
 */
public class OrderBook {

    /**
     * Order book.
     */
    private HashMap<String, HashMap<Integer, Order>> orderBook;

    /**
     * Constructor.
     */
    public OrderBook() {
        this.orderBook = new HashMap<>();
    }

    /**
     * readXML.
     * @param fileName file name.
     */
    public void readXML(String fileName) {
        try {
            XMLStreamReader xmlreed = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));
            while (xmlreed.hasNext()) {
                xmlreed.next();
                if (xmlreed.isStartElement()) {
                    if (xmlreed.getLocalName() == "AddOrder") {
                        String value0 = xmlreed.getAttributeValue(null, "book");
                        if (!orderBook.containsKey(value0)) {
                            orderBook.put(value0, new HashMap<>(700000, 1));
                        }
                        orderBook.get(value0).put(Integer.valueOf(xmlreed.getAttributeValue(null, "orderId")), new Order(Float.parseFloat(xmlreed.getAttributeValue(null, "price")),
                                (xmlreed.getAttributeValue(null, "operation").equals("BUY")
                                        ? Integer.parseInt(xmlreed.getAttributeValue(null, "volume"))
                                        : (-1 * Integer.parseInt(xmlreed.getAttributeValue(null, "volume")))
                                )));
                    } else if (xmlreed.getLocalName() == "DeleteOrder") {
                        orderBook.get(xmlreed.getAttributeValue(null, "book")).remove(Integer.valueOf(xmlreed.getAttributeValue(null, "orderId")));
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * outputOrderBook.
     */
    public void outputOrderBook() {
        for (Map.Entry bookName : orderBook.entrySet()) {
            System.out.println(String.format("Order book: %s", bookName.getKey()));
            System.out.println("     BID            ASK");
            System.out.println("Volume@Price - Volume@Price");

            TreeMap<Float, Integer> bidAsk = new TreeMap<>();
            for (Map.Entry<Integer, Order> entry : orderBook.get(bookName.getKey()).entrySet()) {
                Order order = entry.getValue();
                bidAsk.put(order.getPrice(), (bidAsk.get(order.getPrice()) == null)
                        ? 0
                        : bidAsk.get(order.getPrice())
                        + order.getVolume());
            }

            TreeMap<Float, Integer> ask = new TreeMap<>(Collections.reverseOrder());
            TreeMap<Float, Integer> bid = new TreeMap<>();

            for (Map.Entry<Float, Integer> entry : bidAsk.entrySet()) {
                Integer volume = entry.getValue();
                if (volume == 0) {
                    continue;
                } else if (volume < 0) {
                    ask.put(entry.getKey(), -1 * entry.getValue());
                } else {
                    bid.put(entry.getKey(), entry.getValue());
                }
            }

            Iterator iteratorAsk = ask.entrySet().iterator();
            Iterator iteratorBid = bid.entrySet().iterator();

            while (iteratorAsk.hasNext() || iteratorBid.hasNext()) {
                if (iteratorAsk.hasNext()) {
                    Map.Entry entry = (Map.Entry) iteratorAsk.next();
                    System.out.print(String.format("%6s@%5s - ", entry.getValue(), entry.getKey()));
                } else {
                    System.out.print("-------------- -");
                }
                if (iteratorBid.hasNext()) {
                    Map.Entry entry = (Map.Entry) iteratorBid.next();
                    System.out.println(String.format("%6s@%4s", entry.getValue(), entry.getKey()));
                } else {
                    System.out.println("------------");
                }

            }
        }
    }

}

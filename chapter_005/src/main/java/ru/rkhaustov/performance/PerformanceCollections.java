package ru.rkhaustov.performance;



import java.util.TreeSet;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by rvkha_000 on 16.05.2017.
 */
public class PerformanceCollections {
    /**
     * @param collection collection
     * @param line add text
     * @param amount count
     * @return time
     */
    public long add(Collection<String> collection, String line, int amount) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        String str;
        Random rand = new Random();

        for (int index = 0; index < amount; index++) {
            str = line + (int) (1000 * index * rand.nextDouble());
            collection.add(str);
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * @param collection collection
     * @param amount count
     * @return time
     */
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        int index = 0;
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            if (++index >= amount) {
                break;
            }
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * @param args argument
     */
    public static void main(String[] args) {
        Random rand = new Random();
        PerformanceCollections performanceCollections = new PerformanceCollections();
        String line;
        int count = 20;
        String[] randomString = {"Написать",
                "Программу",
                "Которая",
                "Замеряет",
                "Время",
                "Вставки",
                "Коллекцию",
                "Большого",
                "Количества",
                "Случайных",
                "Строк",
                "Удаления",
                "Коллекции",
                "Первых",
                "элементов",
                "LinkedList",
                "ArrayList",
        };


        ArrayList<String> listArray = new ArrayList<String>();
        LinkedList<String> listLinked = new LinkedList<String>();
        TreeSet<String> listTreeSet = new TreeSet<String>();

        long timeArrayList = 0;
        long timeLinkedList = 0;
        long timeTreeSet = 0;

        for (count = 1; count < 80; count += 20) {
            timeArrayList = 0;
            timeLinkedList = 0;
            timeTreeSet = 0;

            for (int index = 0; index < 50 * count; index++) {
                line = randomString[(int) (17 * rand.nextDouble())];
                timeArrayList += performanceCollections.add(listArray, line, 1000);
                timeLinkedList += performanceCollections.add(listLinked, line, 1000);
                timeTreeSet += performanceCollections.add(listTreeSet, line, 1000);
            }
            System.out.println(String.format("Count add:%s", 500 * count * 1000));
            System.out.println(String.format("Time LinkedList: %s, size:%s", timeLinkedList, listLinked.size()));
            System.out.println(String.format("Time ArrayList: %s, size:%s", timeArrayList, listArray.size()));
            System.out.println(String.format("Time TreeSet: %s, size:%s", timeTreeSet, listTreeSet.size()));
            System.out.println("++++");

            timeArrayList = 0;
            timeLinkedList = 0;
            timeTreeSet = 0;

            timeArrayList += performanceCollections.delete(listArray, count * 1000);
            timeLinkedList += performanceCollections.delete(listLinked, count * 1000);
            timeTreeSet += performanceCollections.delete(listTreeSet, count * 1000);

            System.out.println(String.format("Count delete:%s", count * 1000));
            System.out.println(String.format("Time LinkedList: %s, size:%s", timeLinkedList, listLinked.size()));
            System.out.println(String.format("Time ArrayList: %s, size:%s", timeArrayList, listArray.size()));
            System.out.println(String.format("Time TreeSet: %s, size:%s", timeTreeSet, listTreeSet.size()));
            System.out.println("----");


            listArray.clear();
            listLinked.clear();
            listTreeSet.clear();

            listArray.trimToSize();

        }

    }
    }

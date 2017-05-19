package ru.rkhaustov.performance;

import java.util.*;

/**
 * Created by rvkha_000 on 16.05.2017.
 */
public class PerformanceCollections {
    public long add(Collection<String> collection, String line, int amount) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        String str;
        Random rand = new Random();
//        List<String> collection1 = collection;

        for (int index = 0; index < amount; index++) {
            str = line + (int)(1000 * index * rand.nextDouble());
//            System.out.println(str);
            collection.add(str);
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        int index = 0;
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()) {
            iterator.next();
            iterator.remove();
            if(++index >= amount) {
                break;
            }
        }
        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

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

   /*
        ArrayList<String> list = new ArrayList<String>();
//        LinkedList<String> list = new LinkedList<String>();
//        TreeSet<String> list = new TreeSet<String>();
        long time = 0;
         for (int index = 0; index < 100 * count; index++) {
            line = randomString[(int) (17 * rand.nextDouble())];
            time += performanceCollections.add(list, line, 1000);
        }
        System.out.println(String.format("Count add:%s", 100 * count * 1000));
        System.out.println(String.format("Time %s: %s, size:%s", list.getClass(), time, list.size()));
        System.out.println("++++");

        time = 0;

        time += performanceCollections.delete(list, count *1000);
        System.out.println(String.format("Count delete:%s", count * 1000));
        System.out.println(String.format("Time %s: %s, size:%s", list.getClass(), time, list.size()));

       */

///*
        ArrayList<String> listArray = new ArrayList<String>();
        LinkedList<String> listLinked = new LinkedList<String>();
        TreeSet<String> listTreeSet = new TreeSet<String>();

        long timeArrayList = 0;
        long timeLinkedList = 0;
        long timeTreeSet = 0;

        for ( count = 1; count < 80; count+=20) {
            timeArrayList = 0;
            timeLinkedList = 0;
            timeTreeSet = 0;

            for (int index = 0; index < 50 * count; index ++) {
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

            timeArrayList += performanceCollections.delete(listArray, count *1000);
            timeLinkedList += performanceCollections.delete(listLinked, count * 1000);
            timeTreeSet += performanceCollections.delete(listTreeSet,count * 1000);

            System.out.println(String.format("Count delete:%s", count * 1000));
            System.out.println(String.format("Time LinkedList: %s, size:%s", timeLinkedList, listLinked.size()));
            System.out.println(String.format("Time ArrayList: %s, size:%s", timeArrayList, listArray.size()));
            System.out.println(String.format("Time TreeSet: %s, size:%s", timeTreeSet, listTreeSet.size()));
            System.out.println("----");


            listArray.clear();
            listLinked.clear();
            listTreeSet.clear();

            listArray.trimToSize();
//*/
        }

    }
    }

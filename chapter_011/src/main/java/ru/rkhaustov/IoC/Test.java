package ru.rkhaustov.IoC;

import java.util.*;

/**
 * Created by rvkha_000 on 30.09.2017.
 */
public class Test extends Thread  {

    public static void main(String[] args)  {

        Integer i1 = 10;
        Integer i2 = 10;

        Double d1 = 10d;
        Double d2 = 10d;
        double d3 = 10d;
        double d4 = 10d;

        System.out.println(i1 == i2);
        System.out.println(d1 == d2);
        System.out.println(d3 == d4);

    }

}

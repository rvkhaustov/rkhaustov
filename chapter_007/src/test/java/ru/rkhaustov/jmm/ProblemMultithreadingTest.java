package ru.rkhaustov.jmm;

import org.junit.Test;



/**
 * Created by rvkha_000 on 14.06.2017.
 */
public class ProblemMultithreadingTest {
    /**
     * Output problem multi threading.
     */
    @Test
    public void  printProblemMultithreading() {
        Variable variable = new Variable(0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 0; index < 10; index++) {
                    variable.setVariable(variable.add(variable.getVariable()));
                    System.out.println(String.format("Thread1 is %s - was: %s", index, variable.getVariable()));
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int index = 10; index < 20; index++) {
                    variable.setVariable(variable.getVariable() + 1);
                    System.out.println(String.format("Thread2 is %s - was: %s", index, variable.getVariable()));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
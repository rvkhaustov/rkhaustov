package ru.rkhaustov.prof;

/**
 * Created by rvkha_000 on 20.04.2017.
 */
public class Teacher extends Profession {
    /**
     * @param subject - предмет
     */
    private String subject;
    /**
     * @param qualification - квалификация учителя
     */
    private String qualification;

    /**
     * Method.
     */
    public void teach() {
        System.out.println("Teach");

    }
    /**
     * Method.
     */
    public void meeting() {
        System.out.println("Meeting");
    }
    /**
     * Method.
     */
    public void work() {
        System.out.println("Work");

    }


}

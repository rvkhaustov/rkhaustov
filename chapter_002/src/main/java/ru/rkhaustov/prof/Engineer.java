package ru.rkhaustov.prof;

/**
 * Created by rvkha_000 on 20.04.2017.
 */
public class Engineer extends Profession {
    /**
     * @param grade грейд
     */
    private String grade;
    /**
     * getGrade.
     * @return grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * work.
     */
    public void work() {
        System.out.println("Work");
    }


}


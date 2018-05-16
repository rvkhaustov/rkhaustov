package ru.rvkhaustov.app.services;

/**
 * Created by rvkha_000 on 23.04.2018.
 */
public interface ServicesRun {


    /**
     * @return Execute services.
     */
    long execute();

    /**
     * @param database database
     */
    void setDatabase(String database);

    /**
     * @param  count count
     */
    void setCount(Long count);

}

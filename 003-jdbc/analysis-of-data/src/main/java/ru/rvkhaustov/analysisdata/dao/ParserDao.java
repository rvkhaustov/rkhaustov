package ru.rvkhaustov.analysisdata.dao;

import ru.rvkhaustov.analysisdata.pojo.Vacancy;

/**
 * Created by rvkha_000 on 10.07.2018.
 */
public interface ParserDao {
    /**
     * @return millis.
     */
    Long lastDate();

    /**
     * @param vacancy vacancy
     */
    void insert(Vacancy vacancy);

    /**
     * insertConfig.
     */
    void insertConfig();
}

package ru.rvkhaustov.analysisdata.dao;

import ru.rvkhaustov.analysisdata.dto.Vacancy;

import java.time.LocalDateTime;

/**
 * Created by rvkha_000 on 10.07.2018.
 */
public interface ParserDao {
    /**
     * @return millis.
     */
    LocalDateTime lastDateTime();

    /**
     * @param vacancy vacancy
     */
    void insert(Vacancy vacancy);

    /**
     * insertConfig.
     */
    void insertConfig();
}

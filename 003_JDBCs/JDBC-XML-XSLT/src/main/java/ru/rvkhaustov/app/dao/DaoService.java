package ru.rvkhaustov.app.dao;

import ru.rvkhaustov.app.pojo.Field;

import java.util.List;

/**
 * Created by rvkha_000 on 22.04.2018.
 */
public interface DaoService {
    /**
     * @param from from field
     * @param to   to field
     */
    void insert(long from, long to);

    /**
     * @param from from field
     * @param to   to field
     * @return select fields
     */
    List<Field> select(long from, long to);
}

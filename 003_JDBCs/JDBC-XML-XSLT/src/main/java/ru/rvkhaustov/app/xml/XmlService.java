package ru.rvkhaustov.app.xml;

import ru.rvkhaustov.app.pojo.Field;

import java.util.List;

/**
 * Created by rvkha_000 on 25.04.2018.
 */
public interface XmlService {
    /**
     * @param fields fields
     */
    void createXmlFromDao(List<Field> fields);
}

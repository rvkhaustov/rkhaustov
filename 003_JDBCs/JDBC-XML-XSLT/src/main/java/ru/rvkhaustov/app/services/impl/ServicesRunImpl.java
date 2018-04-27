package ru.rvkhaustov.app.services.impl;

import ru.rvkhaustov.app.dao.DaoService;
import ru.rvkhaustov.app.dao.impl.DaoServiceImpl;
import ru.rvkhaustov.app.pojo.Field;
import ru.rvkhaustov.app.pojo.FieldsXslt;
import ru.rvkhaustov.app.services.ServicesRun;
import ru.rvkhaustov.app.xml.XmlService;
import ru.rvkhaustov.app.xml.impl.XmlServiceImpl;
import ru.rvkhaustov.app.xslt.XsltService;
import ru.rvkhaustov.app.xslt.impl.XsltServiceImpl;

import java.util.Calendar;
import java.util.List;

import static ru.rvkhaustov.app.utils.StaticParameter.ALL_TIME;
import static ru.rvkhaustov.app.utils.StaticParameter.ARIFMETIC_SUM;
import static ru.rvkhaustov.app.utils.StaticParameter.DAO_SERVICE_INSERT;
import static ru.rvkhaustov.app.utils.StaticParameter.DAO_SERVICE_SELECT;
import static ru.rvkhaustov.app.utils.StaticParameter.TRANSFORM_FROM_XML_XLST;
import static ru.rvkhaustov.app.utils.StaticParameter.XML_SERVICE_XML_FROM_DAO;

/**
 * Created by rvkha_000 on 23.04.2018.
 */
public class ServicesRunImpl implements ServicesRun {

    /**
     * database.
     */
    private String database;
    /**
     * count.
     */
    private Long count;
    /**
     * arithmeticSum.
     */
    private long arithmeticSum = 0L;

    /**
     * Execute services.
     */
    @Override
    public long execute() {
        long startService = Calendar.getInstance().getTimeInMillis();
        DaoService daoService = new DaoServiceImpl(database);
        daoService.insert(0, count);
        long insertDaoService = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format(DAO_SERVICE_INSERT, insertDaoService - startService, (insertDaoService - startService) / 1000));

        List<Field> fields = daoService.select(0, count);
        long selectDaoService = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format(DAO_SERVICE_SELECT, selectDaoService - insertDaoService, (selectDaoService - insertDaoService) / 1000));

        XmlService xmlService = new XmlServiceImpl();
        xmlService.createXmlFromDao(fields);
        long createXmlFromDaoXmlService = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format(XML_SERVICE_XML_FROM_DAO, createXmlFromDaoXmlService - selectDaoService,
                 (createXmlFromDaoXmlService - selectDaoService) / 1000));

        XsltService xsltService = new XsltServiceImpl();
        xsltService.transformXmlToXlst();
        long transformFromXmlToXlstXmlService = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format(TRANSFORM_FROM_XML_XLST, transformFromXmlToXlstXmlService - createXmlFromDaoXmlService,
                 (transformFromXmlToXlstXmlService - createXmlFromDaoXmlService) / 1000));

        FieldsXslt fieldsXslt = xsltService.getFildsFromSecondXml();
        fieldsXslt.getFieldXslts().forEach(field -> arithmeticSum += field.getFieldXlst());
        System.out.println("Arithmetic Sum = " + arithmeticSum);
        long endService = Calendar.getInstance().getTimeInMillis();
        System.out.println(String.format(ARIFMETIC_SUM, endService - transformFromXmlToXlstXmlService,
                 (endService - transformFromXmlToXlstXmlService) / 1000));
        System.out.println(String.format(ALL_TIME, endService - startService,
                 (endService - startService) / 1000));
    return arithmeticSum;
    }

    /**
     * @param database database
     */
    @Override
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * @param count
     */
    @Override
    public void setCount(Long count) {
        this.count = count;
    }
}

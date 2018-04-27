package ru.rvkhaustov.app.xslt;

import ru.rvkhaustov.app.pojo.FieldsXslt;

/**
 * Created by rvkha_000 on 26.04.2018.
 */
public interface XsltService {
    /**
     * Transform xml to xslt.
     */
    void transformXmlToXlst();

    /**
     * @return get date from xslt
     */
    FieldsXslt getFildsFromSecondXml();
}

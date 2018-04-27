package ru.rvkhaustov.app.pojo;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by rvkha_000 on 26.04.2018.
 */
public class FieldXslt implements Serializable {
    /**
     * fieldXlst.
     */
    private Integer fieldXlst;


    /**
     * @return Integer
     */
    public Integer getFieldXlst() {
        return fieldXlst;
    }

    /**
     * @param fieldXlst fieldXlst
     */
    @XmlAttribute(name = "field")
    public void setFieldXlst(Integer fieldXlst) {
        this.fieldXlst = fieldXlst;
    }
}

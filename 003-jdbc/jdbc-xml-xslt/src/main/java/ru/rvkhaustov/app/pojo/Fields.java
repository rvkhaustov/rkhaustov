package ru.rvkhaustov.app.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rvkha_000 on 25.04.2018.
 */
@XmlRootElement(name = "entries")
public class Fields implements Serializable {

    /**
     * fieldList.
     */
    private List<Field> fieldList;

    /**
     * @param fieldList fieldList
     */
    @XmlElement(name = "entry")
    public void setFieldList(List<Field> fieldList) {
        this.fieldList = fieldList;
    }

    /**
     * @return fields.
     */
    public List<Field> getFieldList() {
        return fieldList;
    }
}

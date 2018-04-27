package ru.rvkhaustov.app.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by rvkha_000 on 26.04.2018.
 */
@XmlRootElement(name = "entries")
public class FieldsXslt implements Serializable {
    /**
     * fieldXslts.
     */
    private List<FieldXslt> fieldXslts;

    /**
     * @return fieldXslts
     */
    public List<FieldXslt> getFieldXslts() {
        return fieldXslts;
    }

    /**
     * @param fieldXslts fieldXslts
     */
    @XmlElement(name = "entry")
    public void setFieldXslts(List<FieldXslt> fieldXslts) {
        this.fieldXslts = fieldXslts;
    }
}

package ru.rvkhaustov.app.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by rvkha_000 on 25.04.2018.
 */
@XmlRootElement
public class Field implements Serializable {
    /**
     * field.
     */
    private Integer field;

    /**
     * @param field field
     */
    @XmlElement(name = "field")
    public void setField(Integer field) {
        this.field = field;
    }

    /**
     * @return Integer
     */
    public Integer getField() {
        return field;
    }
}

package ru.rvkhaustov.app.xml.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rvkhaustov.app.pojo.Field;
import ru.rvkhaustov.app.pojo.Fields;
import ru.rvkhaustov.app.xml.XmlService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import static ru.rvkhaustov.app.utils.StaticParameter.XML_FIRST_FILE;
import static ru.rvkhaustov.app.utils.StaticParameter.XML_FIRST_FILE_ERROR;

/**
 * Created by rvkha_000 on 25.04.2018.
 */
public class XmlServiceImpl implements XmlService {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(XmlServiceImpl.class);

    @Override
    public void createXmlFromDao(List<Field> fieldList) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Fields.class);
            Marshaller marshaller = jc.createMarshaller();
            Fields fields = new Fields();
            fields.setFieldList(fieldList);
            OutputStream os = new FileOutputStream(XML_FIRST_FILE);
            marshaller.marshal(fields, os);
        } catch (JAXBException | FileNotFoundException e) {
            String message = String.format(XML_FIRST_FILE_ERROR, e.getMessage());
            LOGGER.error(message);
            System.err.println(message);
            System.exit(0);
        }
    }
}

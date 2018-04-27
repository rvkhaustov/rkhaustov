package ru.rvkhaustov.app.xslt.impl;

import ru.rvkhaustov.app.pojo.FieldsXslt;
import ru.rvkhaustov.app.xslt.XsltService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static ru.rvkhaustov.app.utils.StaticParameter.XML_SECOND_FILE;
import static ru.rvkhaustov.app.utils.StaticParameter.XML_FIRST_FILE;
import static ru.rvkhaustov.app.utils.StaticParameter.XSLT_FILE;
import static ru.rvkhaustov.app.utils.StaticParameter.XSLT_FILE_TEXT;

/**
 * Created by rvkha_000 on 26.04.2018.
 */
public class XsltServiceImpl implements XsltService {


    @Override
    public void transformXmlToXlst() {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            File file = new File(XSLT_FILE);
            Files.write(Paths.get(file.toURI()), XSLT_FILE_TEXT.getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            Source xslt = new StreamSource(new File(XSLT_FILE));
            transformer = factory.newTransformer(xslt);
            Source source = new StreamSource(new File(XML_FIRST_FILE));
            transformer.transform(source, new StreamResult(new File(XML_SECOND_FILE)));
        } catch (Exception e) {
            System.err.println("ERROR:  Can not transform to second xml file, " + e.getMessage());
            System.err.println("Program terminated");
            System.exit(0);
        }
    }

    /**
     * @return FieldsXslt.
     */
    public FieldsXslt getFildsFromSecondXml() {
        FieldsXslt fieldsXslt = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(FieldsXslt.class);
            Unmarshaller u = jc.createUnmarshaller();
            fieldsXslt = (FieldsXslt) u.unmarshal(new File(XML_SECOND_FILE));
        } catch (JAXBException e) {
            System.err.println("ERROR:  Can not unmarshal second xml file, " + e.getMessage());
            System.err.println("Program terminated");
            System.exit(0);
        }
        return fieldsXslt;
    }
}

package Parser;

import Entities.Kid;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XMLWriter {
    private static final File file = new File(System.getProperty("user.dir") + "\\testing.xml");
    private static DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private static Transformer transformer;
    private static DocumentBuilder docBuilder;
    private static DOMSource source;
    private static StreamResult result = new StreamResult(file);
    private static Document doc;

    public void addKid(Kid newKid) {
        Element rootElement;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            transformer = transformerFactory.newTransformer();
            if (file.length() != 0) {
                doc = docBuilder.parse(file);
                rootElement = doc.getDocumentElement();
            } else {
                doc = docBuilder.newDocument();
                rootElement = doc.createElement("Kids");
                doc.appendChild(rootElement);
            }
            Element kid = doc.createElement("kid");
            rootElement.appendChild(kid);
            //заполнение данными
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(String.valueOf(newKid.getId())));
            kid.appendChild(id);
            Element groupId = doc.createElement("groupid");
            groupId.appendChild(doc.createTextNode(String.valueOf(newKid.getGroupId())));
            kid.appendChild(groupId);
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode(newKid.getFirstName()));
            kid.appendChild(firstname);
            Element secondName = doc.createElement("secondname");
            secondName.appendChild(doc.createTextNode(newKid.getSecondName()));
            kid.appendChild(secondName);
            Element middleName = doc.createElement("middlename");
            middleName.appendChild(doc.createTextNode(newKid.getMiddleName()));
            kid.appendChild(middleName);
            Element mothersName = doc.createElement("mothersname");
            mothersName.appendChild(doc.createTextNode(newKid.getMothersName()));
            kid.appendChild(mothersName);
            Element boxId = doc.createElement("boxid");
            boxId.appendChild(doc.createTextNode(String.valueOf(newKid.getBoxId())));
            kid.appendChild(boxId);
            Element age = doc.createElement("age");
            age.appendChild(doc.createTextNode(String.valueOf(newKid.getAge())));
            kid.appendChild(age);
            //Запись в файл
            source = new DOMSource(doc);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }


}

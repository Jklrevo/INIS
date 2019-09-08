package Parser;

import Entities.Kid;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXPars extends DefaultHandler {

    private static ArrayList<Kid>  kids;
    Kid kid;
    String thisElement = "";

    public static ArrayList<Kid> getResult(){
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXPars handler=new SAXPars();
            parser.parse(new File(System.getProperty("user.dir")+"\\testing.xml"),handler);
        }catch (ParserConfigurationException|SAXException| IOException e){
            e.printStackTrace();
        }
        return kids;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
        kids=new ArrayList<>();
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        if(thisElement.equals("kid"))
            kid=new Kid();
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if(thisElement.equals("age"))
            kids.add(kid);
        thisElement="";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("id")) {
            kid.setId(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("groupid")) {
            kid.setGroupId(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("firstname")) {
            kid.setFirstName(new String(ch, start, length));
        }
        if (thisElement.equals("secondname")) {
            kid.setSecondName(new String(ch, start, length));
        }
        if (thisElement.equals("middlename")) {
            kid.setMiddleName(new String(ch, start, length));
        }
        if (thisElement.equals("mothersname")) {
            kid.setMothersName(new String(ch, start, length));
        }
        if (thisElement.equals("boxid")) {
            kid.setBoxId(Integer.parseInt(new String(ch, start, length)));
        }
        if (thisElement.equals("age")) {
            kid.setAge(Integer.parseInt(new String(ch, start, length)));
        }

    }


    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}

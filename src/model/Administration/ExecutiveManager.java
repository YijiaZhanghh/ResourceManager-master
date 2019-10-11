package model.Administration;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.MalformedParametersException;

public class ExecutiveManager {

    public static String displayer(String s)throws MalformedParametersException, IOException{
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            // move the file to the project folder
            Document d = db.parse("data/2018exe.xml");
            NodeList exeList = d.getElementsByTagName("Record");
            for(int i = 0; i< 9; i++) {
                Node elist = exeList.item(i);
                NodeList childNodes = elist.getChildNodes();
                if (childNodes.item(3).getFirstChild().getNodeValue().contains(s)) {
                    return(exeList.item(i).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

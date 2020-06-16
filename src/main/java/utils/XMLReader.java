package utils;

import constans.RegexPattern;
import constans.XMLpath;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLReader {
    public XMLReader() throws ParserConfigurationException, IOException, SAXException {
    }

    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document docXML2task = dBuilder.parse(XMLpath.pathToTask);

    NodeList firstLineCase1 = docXML2task.getElementsByTagName(XMLpath.firstTagCase1);
    NodeList secondLineCase1 = docXML2task.getElementsByTagName(XMLpath.secondTagCase1);

    NodeList sourceLineCase2 = docXML2task.getElementsByTagName(XMLpath.firstTagCase2);
    NodeList repeatWordCase2 = docXML2task.getElementsByTagName(XMLpath.secondTagCase2);

    public String[] firstPhrase = firstLineCase1.item(0).getTextContent().replaceAll(RegexPattern.marks, " ").split(RegexPattern.words);
    public String secondPhrase = secondLineCase1.item(0).getTextContent().replaceAll(RegexPattern.marks, " ");
    public String[] sourceLine = sourceLineCase2.item(0).getTextContent().replaceAll(RegexPattern.marks, " ").split(" ");
    public String[] charsOfSourcePhrase = sourceLineCase2.item(0).getTextContent().split("");
    public String repeatedWord = repeatWordCase2.item(0).getTextContent();

}

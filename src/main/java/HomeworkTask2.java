import org.xml.sax.SAXException;
import utils.CounterOfMarks;
import utils.MissingWords;
import utils.RepeatOfWord;
import utils.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class HomeworkTask2 {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        XMLReader xml = new XMLReader();

        //case 1
        System.out.println("Слова первой строки, которые отсутствуют во второй строке - " + MissingWords.getMissingWords(xml.firstPhrase, xml.secondPhrase));
        //case 2
        System.out.println("Количество повторения слова \"" + xml.repeatedWord + " - " + RepeatOfWord.getCountOfWord(xml.sourceLine, xml.repeatedWord));
        System.out.println("Количество знаков препинания - " + CounterOfMarks.getCountOfMark(xml.charsOfSourcePhrase));


    }
}



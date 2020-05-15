import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        //получаем данные из XML
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document docXML2task = dBuilder.parse("src\\main\\resources\\2task.xml");
        //создаем NodeList с необходимыми стрингами
        //получаем текст для задания 1
        NodeList case1 = docXML2task.getElementsByTagName("case_1_phrase");
        //получаем текст для задания 2 - исследуемая фраза
        NodeList case2SourceLine = docXML2task.getElementsByTagName("sourceLine");
        //получаем текст для задания 2 - искомое слово
        NodeList case2repeatWord = docXML2task.getElementsByTagName("repeatWord");
        //получаем текст для задания 2 - знаки для подсчета
        NodeList case2marks = docXML2task.getElementsByTagName("punctuation_marks");


        //приложение 1
        System.out.println("Задание 1");

        //создаем массив, в котором разместим строки задания 1
        String[] case1Phrase = new String[2];

        for (int i=0; i< case1.getLength(); i++) {
            case1Phrase[i] = case1.item(i).getTextContent();
        }
        //выделяем массив слов первой фразы
        String[] phrase1 = case1Phrase[0].split(" ");
        //выделяем массив слов второй фразы
        String[] phrase2 = case1Phrase[1].split(" ");
        //проверяем и выводим в консоль все слова из первой строки,
        //которые отсутствуют во второй
        for (int i = 0; i < phrase1.length; i++) {
            if (!case1Phrase[1].contains(phrase1[i])) {
        System.out.println("слово из первой строки -  "  + phrase1[i] + " отсутствует во второй строке");}
        }

        //приложение 2
        System.out.println("Задание 2");
        //сначала определим количество знаков препинания в исследуемой фразе задания 2
        //для этого приведем искомую строку к типу String
        String sourceLine = case2SourceLine.item(0).getTextContent();
        //также получим знаки препинания
        String punctuationMarks = case2marks.item(0).getTextContent();
        // и посчитаем их количество в искомом предложении
        int countOfMarks = 0;
        for (int i=0; i < sourceLine.length(); i++) {
            if (punctuationMarks.indexOf(sourceLine.toCharArray()[i]) >= 0) {
                countOfMarks++;
            }
        }
        //заменим знаки препинания на пробелы
        String sourceLineWithoutMarks = sourceLine.replaceAll("[.,!?:…]", " ");

        //преобразуем в string искомое слово
        String repeatWord = case2repeatWord.item(0).getTextContent();

        //разобьём строку на массив из слов и проверим сколько раз искомое слово встречается в исследуемой фразе
        int countOfRepeat = 0;
        String[] sourceLineArr = sourceLineWithoutMarks.split(" ");
        for (int i=0; i< sourceLineArr.length; i++){
            if (repeatWord.equalsIgnoreCase(sourceLineArr[i])) {
                countOfRepeat++;
            }
        }

        System.out.println("Количество повторений искомого слова - " + countOfRepeat);
        System.out.println("Количество знаков препинания- " + countOfMarks);

    }
}



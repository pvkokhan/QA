package utils;

import java.util.ArrayList;

public class MissingWords {
    public static ArrayList<String> getMissingWords(String[] firstPhrase, String secondPhrase) {
        ArrayList<String> words = new ArrayList<>();
        for (String wordOfFirstPhrase : firstPhrase) {
            if (secondPhrase.contains(wordOfFirstPhrase)) {
            } else {
                words.add(wordOfFirstPhrase);
            }
        }
        return words;

    }
}

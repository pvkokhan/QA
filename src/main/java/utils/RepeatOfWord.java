package utils;

public class RepeatOfWord {

    public static int getCountOfWord(String[] sourceLine, String repeatedWord) {
        int counter = 0;
        for (String word : sourceLine) {
            if (word.equals(repeatedWord)) {
                counter++;
            }
        }
        return counter;
    }
}
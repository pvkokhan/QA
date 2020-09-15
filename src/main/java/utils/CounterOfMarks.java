package utils;

import constans.RegexPattern;

public class CounterOfMarks {
    public static int getCountOfMark(String[] charArray) {
        int counter = 0;
        for (String symbol : charArray) {
            if (RegexPattern.marks.contains(symbol)) {
                counter++;
            }
        }
        return counter;
    }
}
package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ua.nure.temnokhud.task3.Functions.readFile;

public class Part1 {
    final static String FILE_NAME = "part1.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(readFile(FILE_NAME));
        System.out.println("--------");
        System.out.println(changeCase(readFile(FILE_NAME)));
    }

    private static String changeCase(StringBuilder elements) {
        StringBuilder answer = new StringBuilder(elements);
        Pattern pattern = Pattern.compile("([\\w&&[\\D]]{4,})", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(answer);

        while (matcher.find()) {
            String elem = matcher.group();
            int index = matcher.start();//answer.lastIndexOf(elem);
            Pattern patternSmall = Pattern.compile("\\w", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcherSmall = patternSmall.matcher(elem);

            while (matcherSmall.find()) {
                String subElem = matcherSmall.group();
                int subIndex = matcherSmall.start();
                if (Character.isLowerCase(subElem.toCharArray()[0])) {
                    answer.delete(index + subIndex, index + subIndex + 1);
                    answer.insert(index + subIndex, subElem.toUpperCase());
                } else if (Character.isUpperCase(subElem.toCharArray()[0])) {
                    answer.delete(index + subIndex, index + subIndex + 1);
                    answer.insert(index + subIndex, subElem.toLowerCase());
                }
            }
        }
        return answer.toString();
    }

}

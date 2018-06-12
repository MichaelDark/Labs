package ua.nure.temnokhud.task3;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;

public class Utility {
    private Utility() {}

    public static StringBuilder readFile(String fileName) throws IOException {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                answer.append(line).append(System.lineSeparator());
            }
            answer.delete(answer.lastIndexOf(System.lineSeparator()), answer.length());
        }
        return answer;
    }

    //Part 1
    public static String changeCase(StringBuilder elements) {
        StringBuilder result = new StringBuilder(elements);
        Pattern patternWord = Pattern.compile("[\\w\\S]{3,}", Pattern.UNICODE_CHARACTER_CLASS);
        Pattern patternLetter = Pattern.compile("\\w", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcherWord = patternWord.matcher(result);
        Matcher matcherLetter;
        String word;
        String letter;

        while (matcherWord.find()) {
            word = matcherWord.group();
            int index = matcherWord.start();
            matcherLetter = patternLetter.matcher(word);

            while (matcherLetter.find()) {
                letter = matcherLetter.group();
                int subIndex = matcherLetter.start();
                if (Character.isLowerCase(letter.charAt(0))) {
                    result.delete(index + subIndex, index + subIndex + 1);
                    result.insert(index + subIndex, letter.toUpperCase());
                } else if (Character.isUpperCase(letter.charAt(0))) {
                    result.delete(index + subIndex, index + subIndex + 1);
                    result.insert(index + subIndex, letter.toLowerCase());
                }
            }
        }
        return result.toString();
    }

    //Part 2
    public static String deleteRepeat(StringBuilder file) {
        StringBuilder result = new StringBuilder(file);
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(file);
        int shift = 0;
        while (matcher.find()) {
            String elem = matcher.group();
            int index = matcher.start();
            Pattern subPattern = Pattern.compile("(\\w).*\\1", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher subMatcher = subPattern.matcher(elem);
            if (subMatcher.find()) {
                result.delete(index - shift, index - shift + elem.length());
                shift += elem.length();
            }
        }

        return Pattern.compile("[\\s]+").matcher(result).replaceAll(" ").trim();
    }

    //Part 3
    public static String deleteDuplicates(StringBuilder file) {
        StringBuilder copyFile = new StringBuilder(file);
        List<String> allDuplicates = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?=.*?(\\1)+)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            String elem = matcher.group(1);
            allDuplicates.add(elem);
        }
        Pattern pattern1 = Pattern.compile("\\s*(\\w+)\\s*", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher1 = pattern1.matcher(file);
        int shift = 0;
        while(matcher1.find()){
            for (String elem : allDuplicates) {
                String word = matcher1.group(1);
                int index = matcher1.start();
                if(Objects.equals(elem, word)){
                    copyFile.delete(index - shift, index - shift + elem.length());
                    shift += elem.length();
                    break;
                }
            }
        }

        return Pattern.compile("[\\s]+").matcher(copyFile).replaceAll(" ").trim();
    }

    //Part 4
    public static String getPatternedString(Pattern pattern, String content) {
        Matcher matcher = pattern.matcher(content);
        StringBuilder answer = new StringBuilder();
        while(matcher.find()){
            answer.append(matcher.group()).append(" ");
        }
        answer.delete(answer.length() - 1, answer.length());

        return answer.toString();
    }

    //Part 5
    static String convert1(String input) {
        Pattern pattern = Pattern.compile("(\\w+)(?:;)(?:[\\w\\s]+)(?:;)(.+)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group(1));
            builder.append(" ==> ");
            builder.append(matcher.group(2));
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static String convert2(String input) {
        Pattern pattern = Pattern.compile("(?:\\w+)(?:;)([\\w]+)(?:\\s)([\\w]+)(?:;)(.+)", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        StringBuilder builder = new StringBuilder();
        while (matcher.find()) {
            builder.append(matcher.group(1));
            builder.append(" ").append(matcher.group(2));
            builder.append(" (email: ");
            builder.append(matcher.group(3));
            builder.append(")");
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static String convert3(String input) {
        Pattern pattern = Pattern.compile("(.[^;]+)(?:.[^@]+)(?:@)(.+)",Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(input);
        List<StringBuilder> list = new ArrayList<>();
        while (matcher.find()) {
            boolean found = false;
            for (StringBuilder temp : list) {
                if (temp.indexOf(matcher.group(2)) != -1) {
                    temp.append(", ");
                    temp.append(matcher.group(1));
                    found = true;
                    break;
                }
            }
            if (!found) {
                StringBuilder tmp = new StringBuilder();
                tmp.append(matcher.group(2));
                tmp.append(" ==> ");
                tmp.append(matcher.group(1));
                list.add(tmp);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}

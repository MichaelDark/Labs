package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ua.nure.temnokhud.task3.Functions.readFile;

public class Part5 {
    final static String FILE_NAME = "part5.txt";

    public static String convert1(String input) {
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
                list.add(new StringBuilder().append(matcher.group(2) + " ==> " + matcher.group(1)));
            }
        }

        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder);
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public static void main(String[] args) throws IOException {
        String file = String.valueOf(readFile(FILE_NAME));
        System.out.println(convert1(file));
        System.out.println();
        System.out.println(convert2(file));
        System.out.println();
        System.out.println(convert3(file));
    }

}

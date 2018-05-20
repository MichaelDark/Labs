package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ua.nure.temnokhud.task3.Functions.readFile;

public class Part2 {
    final static String FILE_NAME = "part2.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder file = readFile(FILE_NAME);
        System.out.println(file);
        System.out.println("-----");
        String output = deleteRepeat(file);
        System.out.println(output);
    }

    private static String deleteRepeat(StringBuilder file) {
        StringBuilder copyFile = new StringBuilder(file);
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(file);
        int shift = 0;
        while (matcher.find()) {
            String elem = matcher.group();
            int index = matcher.start();
            Pattern subPattern = Pattern.compile("(\\w).*\\1", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher subMatcher = subPattern.matcher(elem);
            if (subMatcher.find()) {
                copyFile.delete(index - shift, index - shift + elem.length());
                shift += elem.length();
            }
        }

        Pattern CLEAR_PATTERN = Pattern.compile("[\\s]+");
        String answer = CLEAR_PATTERN.matcher(copyFile).replaceAll(" ").trim();
        // without spaces
        //return answer;
        System.out.println("without spaces:");
        System.out.println(answer);
        // original
        return copyFile.toString();
    }
}

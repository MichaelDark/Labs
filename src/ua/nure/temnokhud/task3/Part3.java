package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ua.nure.temnokhud.task3.Functions.readFile;

public class Part3 {
    final static String FILE_NAME = "part3.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder file = readFile(FILE_NAME);
        System.out.println(file);
        System.out.println("-----");
        String output = deleteRepeat(file);
        System.out.println(output);
    }

    private static String deleteRepeat(StringBuilder file) {
        StringBuilder copyFile = new StringBuilder(file);
        List<String> allDublicates = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b(?=.*?(\\1)+)", Pattern.UNICODE_CHARACTER_CLASS); //\\b(\\w+)(?:\\s+\\1\\b)+ // \b(\w+)\b.*\1
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            String elem = matcher.group(1);
            allDublicates.add(elem);
        }
        Pattern pattern1 = Pattern.compile("\\s*(\\w+)\\s*", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher1 = pattern1.matcher(file);
        int shift = 0;
        while(matcher1.find()){
            for (String elem :
                    allDublicates) {
                String word = matcher1.group(1);
                int index = matcher1.start();
                if(Objects.equals(elem, word)){
                    copyFile.delete(index - shift, index - shift + elem.length());
                    shift += elem.length();
                    break;
                }
            }
        }

        System.out.println();
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


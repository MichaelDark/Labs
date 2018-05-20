package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ua.nure.temnokhud.task3.Functions.readFile;

public class Part4 {
    final static String FILE_NAME = "part4.txt";

    public static void main(String[] args) throws IOException {
        String content = readFile(FILE_NAME).toString();
        System.out.println(content);
        Pattern pattern;

        try(Scanner scanner = new Scanner(System.in)){
            while (scanner.hasNext()){
                String value = scanner.next();
                if(value.equals("stop")) break;
                switch (value){
                    /*case "char":
                        pattern = Pattern.compile("\\b([\\w&&[\\D]]{1})\\b", Pattern.UNICODE_CHARACTER_CLASS);
                        WritePatternToConsole(pattern, content);
                        break;*/
                    case "int":
                        pattern = Pattern.compile("\\b(?<!\\.)(\\d+)(?!\\.)\\b");
                        WritePatternToConsole(pattern, content);
                        break;
                    case "String":
                        pattern = Pattern.compile("\\b([\\w&&[\\D]]{1,})\\b", Pattern.UNICODE_CHARACTER_CLASS);
                        WritePatternToConsole(pattern, content);
                        break;
                    case "double":
                        pattern = Pattern.compile("\\b(\\d+\\.\\d+)|(\\d+\\.)|(\\.\\d+)\\b");
                        WritePatternToConsole(pattern, content);
                        break;

                }
            }
        }
    }

    private static void WritePatternToConsole(Pattern pattern, String content) {
        Matcher matcher = pattern.matcher(content);
        StringBuilder answer = new StringBuilder();
        while(matcher.find()){
            answer.append(matcher.group()).append(" ");
        }
        answer.delete(answer.length() - 1, answer.length());

        System.out.println(answer);
    }
}

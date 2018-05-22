package ua.nure.temnokhud.task3;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.in;
import static java.lang.System.out;
import static ua.nure.temnokhud.task3.Functions.readFile;
import static ua.nure.temnokhud.task3.Functions.getPatternedString;

public class Part4 {
    private static final String FILE_NAME = "part4.txt";

    public static void main(String[] args) throws IOException {
        String content = readFile(FILE_NAME).toString();
        out.println(content);
        Pattern pattern;

        try(Scanner scanner = new Scanner(in)){
            while (scanner.hasNext()){
                String value = scanner.next();
                if(value.equals("stop")) break;
                switch (value){
                    case "int":
                        pattern = Pattern.compile("\\b(?<!\\.)(\\d+)(?!\\.)\\b");
                        out.println(getPatternedString(pattern, content));
                        break;
                    case "String":
                        pattern = Pattern.compile("\\b([\\w&&[\\D]]{1,})\\b", Pattern.UNICODE_CHARACTER_CLASS);
                        out.println(getPatternedString(pattern, content));
                        break;
                    case "double":
                        pattern = Pattern.compile("\\b(\\d+\\.\\d+)|(\\d+\\.)|(\\.\\d+)\\b");
                        out.println(getPatternedString(pattern, content));
                        break;
                    default:
                        out.println("Invalid query");
                        break;

                }
            }
        }
    }
}

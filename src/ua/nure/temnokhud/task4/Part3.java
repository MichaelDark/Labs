package ua.nure.temnokhud.task4;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    private static void print(String input) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Locale.setDefault(new Locale(scanner.nextLine()));
            System.out.println("Current Locale: " + Locale.getDefault());
            ResourceBundle mybundle = ResourceBundle.getBundle("resources");
            System.out.println(mybundle.getString(scanner.nextLine()));
            System.out.println(mybundle.getString(scanner.nextLine()));
        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        print("ru\napple\ntable");
        print("en\napple\ntable");
    }
}
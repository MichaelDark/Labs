package ua.nure.temnokhud.task4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import static java.lang.System.out;

public class Part3 {
    private static void print(String input) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);
            Locale.setDefault(new Locale(scanner.nextLine()));
            out.println("Current Locale: " + Locale.getDefault());
            ResourceBundle mybundle = ResourceBundle.getBundle("resources");
            out.println(mybundle.getString(scanner.nextLine()));
            out.println(mybundle.getString(scanner.nextLine()));
        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        print("ru\napple\ntable");
        print("en\napple\ntable");
    }
}
package ua.nure.temnokhud.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.temnokhud.task4.Utility.readFile;

public class Part4 {
    private static final String FILE_NAME_IN = "task44.txt";
    private static final String FILE_NAME_OUT = "task44_sorted.txt";

    public static void process() throws IOException {
        String[] input = readFile(FILE_NAME_IN).toString().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        try {
            File file = new File(FILE_NAME_OUT);
            try (FileWriter fileWriter = new FileWriter(file)) {
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = numbers.length - 1; j > 0; j--) {

                        if (numbers[j] < numbers[j - 1]) {
                            int temp = numbers[j - 1];
                            numbers[j - 1] = numbers[j];
                            numbers[j] = temp;
                        }

                    }
                    fileWriter.write(Integer.toString(numbers[i]) + " ");

                }
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void generate() {
        Random rand = new Random();

        String[] numbers = new String[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = Integer.toString(rand.nextInt(50));
        }
        try {
            File file = new File("part4.txt");
            try(FileWriter fileWriter = new FileWriter(file)) {
                fileWriter.write(String.join(" ", numbers));
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print() throws IOException {
        StringBuilder input = readFile(FILE_NAME_IN);
        System.out.println(input);

        StringBuilder inputSorted = readFile(FILE_NAME_OUT);
        System.out.println(inputSorted);


    }

    public static void main(String[] args) throws IOException {
        generate();
        process();
        print();
    }
}

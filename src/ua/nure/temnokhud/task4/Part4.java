package ua.nure.temnokhud.task4;

import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import static java.lang.System.*;
import static ua.nure.temnokhud.task4.Utility.readFile;

public class Part4 {
    private static final String FILE_NAME_IN = "task44.txt";
    private static final String FILE_NAME_OUT = "task44_sorted.txt";

    public static void generate() throws Exception {
        Random rand = new Random();

        String[] numbers = new String[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = Integer.toString(rand.nextInt(50));
        }
        try {
            File file = new File(FILE_NAME_IN);
            try (OutputStreamWriter writer =
                         new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                writer.write(String.join(" ", numbers));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void process() throws IOException {
        String[] input = readFile(FILE_NAME_IN).toString().split("\\s");

        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        try {
            File file = new File(FILE_NAME_OUT);
            try (OutputStreamWriter writer =
                         new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                for (int i = 0; i < numbers.length; i++) {
                    for (int j = numbers.length - 1; j > 0; j--) {

                        if (numbers[j] < numbers[j - 1]) {
                            int temp = numbers[j - 1];
                            numbers[j - 1] = numbers[j];
                            numbers[j] = temp;
                        }

                    }
                    writer.write(Integer.toString(numbers[i]) + " ");
                }
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print() throws Exception {
        StringBuilder input = readFile(FILE_NAME_IN);
        out.println(input);

        StringBuilder inputSorted = readFile(FILE_NAME_OUT);
        out.println(inputSorted);


    }

    public static void main(String[] args) throws Exception {
        generate();
        process();
        print();
    }
}

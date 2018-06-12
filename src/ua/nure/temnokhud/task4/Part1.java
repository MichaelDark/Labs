package ua.nure.temnokhud.task4;

import java.io.IOException;

import static java.lang.System.out;

public class Part1 {
    private static final String FILE_NAME = "task41.txt";

    public static void main(String[] args) throws IOException {
        FileIterator fileIterator = new FileIterator(FILE_NAME);
        for (String word : fileIterator) {
            out.println(word);
        }
        out.println();
    }
}

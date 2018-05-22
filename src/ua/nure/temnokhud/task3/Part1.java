package ua.nure.temnokhud.task3;

import java.io.IOException;

import static java.lang.System.out;
import static ua.nure.temnokhud.task3.Functions.readFile;
import static ua.nure.temnokhud.task3.Functions.changeCase;

public class Part1 {
    private static final String FILE_NAME = "part1.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder file = readFile(FILE_NAME);

        out.println(file);
        out.println("--------");
        out.println(changeCase(file));
    }


}

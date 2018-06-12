package ua.nure.temnokhud.task3;

import java.io.IOException;

import static java.lang.System.out;
import static ua.nure.temnokhud.task3.Utility.readFile;
import static ua.nure.temnokhud.task3.Utility.deleteRepeat;

public class Part2 {
    private static final String FILE_NAME = "part2.txt";

    public static void main(String[] args) throws IOException {
        StringBuilder file = readFile(FILE_NAME);

        out.println(file);
        out.println("-----");
        out.println(deleteRepeat(file));
    }


}

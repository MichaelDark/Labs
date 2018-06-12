package ua.nure.temnokhud.task3;

import java.io.IOException;

import static java.lang.System.out;
import static ua.nure.temnokhud.task3.Utility.readFile;
import static ua.nure.temnokhud.task3.Utility.convert1;
import static ua.nure.temnokhud.task3.Utility.convert2;
import static ua.nure.temnokhud.task3.Utility.convert3;

public class Part5 {
    private static final String FILE_NAME = "part5.txt";

    public static void main(String[] args) throws IOException {
        String file = String.valueOf(readFile(FILE_NAME));
        out.println(convert1(file));
        out.println();
        out.println(convert2(file));
        out.println();
        out.println(convert3(file));
    }

}

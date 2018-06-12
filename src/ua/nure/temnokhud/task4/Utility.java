package ua.nure.temnokhud.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
    private Utility() {}

    public static StringBuilder readFile(String fileName) throws IOException {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                answer.append(line).append(System.lineSeparator());
            }
            answer.delete(answer.lastIndexOf(System.lineSeparator()), answer.length());
        }
        return answer;
    }
}

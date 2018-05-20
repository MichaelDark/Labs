package ua.nure.temnokhud.task3;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Functions {

    public static StringBuilder readFile(String FileName) throws IOException {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(FileName), "UTF-8"))) {
            String line = null;
            while ((line = in.readLine()) != null) {
                answer.append(line).append(System.lineSeparator());
            }
            answer.delete(answer.lastIndexOf(System.lineSeparator()), answer.length());
        }
        return answer;
    }
}

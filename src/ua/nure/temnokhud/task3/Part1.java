package ua.nure.temnokhud.task3;

import java.io.*;
import static java.lang.Character.*;

public class Part1 {

    public static void main(String... args) {
        String text = readAllFile("Part1.txt");
        String[] rows = text.split("\r\n");

        System.out.println("Input before: ");
        printRows(rows);

        for(int i = 0; i < rows.length; i++) {
            String[] words = rows[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                if (words[j].length() > 2) {
                    words[j] = invertCase(words[j]);
                }
            }
            rows[i] = String.join(" ", words);
        }

        System.out.println("Input after: ");
        printRows(rows);
    }

    public static String readAllFile(String filePath) {
        String fileText = "";

        try(FileReader reader = new FileReader("Part1.txt")) {
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(reader);

            while((line = bufferedReader.readLine()) != null) {
                fileText += line + "\r\n";
            }
            bufferedReader.close();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return fileText;
    }

    public static void printRows(String[] rows) {
        for(String row : rows) {
            System.out.println(row);
        }
    }

    public static String invertCase(String string) {
        char[] symbols = string.toCharArray();
        for (int i = 0; i < symbols.length; i++)
        {
            char c = symbols[i];
            if (isUpperCase(c))
            {
                symbols[i] = toLowerCase(c);
            }
            else if (isLowerCase(c))
            {
                symbols[i] = toUpperCase(c);
            }
        }
        return new String(symbols);
    }
}

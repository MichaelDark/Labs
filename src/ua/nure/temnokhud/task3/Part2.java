package ua.nure.temnokhud.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part2 {

    public static void main(String... args) {
        String[] rows = readAllFile("Part2.txt");

        System.out.println("Input before: ");
        printRows(rows);

        for(int i = 0; i < rows.length; i++) {
            String[] words = rows[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                if(hasEqualSymbols(words[j])) {
                    words[j] = "";
                }
            }
            rows[i] = String.join(" ", words);
        }

        System.out.println("Input after: ");
        printRows(rows);

    }

    public static String[] readAllFile(String filePath) {
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
        return fileText.split("\r\n");
    }

    public static void printRows(String[] rows) {
        for(String row : rows) {
            System.out.println(row);
        }
    }

    public static boolean hasEqualSymbols(String string) {
        char[] word = string.toCharArray();

        for(int i = 0; i < word.length; i++) {
            for(int j = i + 1; j < word.length; j++) {
                if(word[i] == word[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

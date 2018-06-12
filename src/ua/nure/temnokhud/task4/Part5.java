package ua.nure.temnokhud.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Part5 {

    public static void main(String[] args) {
        String fileName = "task45.txt";
        WordContainer wc = new WordContainer(fileName);
        ArrayList words = wc.sort();
        Word[] words3 = new Word[3];

        for (int i = 0; i < words.size() && i < 3; i++) {
            words3[i] = (Word) words.get(i);
        }
        for (int i = 0; i < words3.length; i++) {
            for (int j = words3.length - 1; j > 0; j--) {

                if (words3[j].getText().compareTo(words3[j - 1].getText()) < 0) {
                    Word temp = words3[j - 1];
                    words3[j - 1] = words3[j];
                    words3[j] = temp;
                }

            }

        }
        for (int i = 0; i < words3.length && i < 3; i++) {
            System.out.println(words3[i].getText() + " ===> " +  words3[i].getFrequency());
        }
    }
}

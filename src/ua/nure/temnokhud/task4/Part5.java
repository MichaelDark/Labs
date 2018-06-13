package ua.nure.temnokhud.task4;

import java.util.List;

import static java.lang.System.out;

public class Part5 {

    public static void main(String[] args) {
        String fileName = "task45.txt";
        WordContainer wc = new WordContainer(fileName);
        List words = wc.sort();
        Word[] result = new Word[3];

        for (int i = 0; i < words.size() && i < 3; i++) {
            result[i] = (Word) words.get(i);
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = result.length - 1; j > 0; j--) {

                if (result[j].getText().compareTo(result[j - 1].getText()) < 0) {
                    Word temp = result[j - 1];
                    result[j - 1] = result[j];
                    result[j] = temp;
                }

            }

        }
        for (int i = 0; i < result.length && i < 3; i++) {
            out.println(result[i].getText() + " ===> " +  result[i].getFrequency());
        }
    }
}

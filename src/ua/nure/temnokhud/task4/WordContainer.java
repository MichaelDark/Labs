package ua.nure.temnokhud.task4;

import static ua.nure.temnokhud.task4.Utility.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordContainer {
    ArrayList<Word> words = new ArrayList<>();

    public WordContainer(String path) {
        StringBuilder input;
        try {
            input = readFile(path);
        } catch (Exception ex) {
            return;
        }
        Pattern p = Pattern.compile("\\b[\\p{L}-]+\\b");
        Matcher m = p.matcher(input);
        while (m.find()) {
            Word word = new Word(m.group());
            int index = this.words.indexOf(word);
            if (index != -1) {
                this.words.get(index).incrementFrequency();
            } else {
                this.words.add(word);
            }
        }
    }
    public ArrayList<Word> getWords(){
        return this.words;
    }
    public ArrayList<Word> sort() {
        Collections.sort(this.words);
        return this.words;
    }

    public void print() {
        for (Word word : this.words) {
            System.out.println("'" + word.getText() + "': " + word.getFrequency());
        }
    }

}

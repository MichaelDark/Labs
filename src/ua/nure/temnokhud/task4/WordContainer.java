package ua.nure.temnokhud.task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;
import static ua.nure.temnokhud.task4.Utility.readFile;

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
    public List<Word> getWords(){
        return this.words;
    }
    public List<Word> sort() {
        Collections.sort(this.words);
        return this.words;
    }

    public void print() {
        for (Word word : this.words) {
            out.println("'" + word.getText() + "': " + word.getFrequency());
        }
    }

}

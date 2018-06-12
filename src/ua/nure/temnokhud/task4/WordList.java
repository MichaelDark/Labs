package ua.nure.temnokhud.task4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordList implements Iterable<String> {
    ArrayList<String> words = new ArrayList<>();


    WordList(String path) {
        String input = null;
        try {
            input = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + path + "'");
            return;
        } catch (IOException ex) {
            System.out.println("Error reading file '" + path + "'");
            return;
        }
        System.out.println("input = " + input);
        Pattern p = Pattern.compile("\\b[\\p{L}-]+\\b");
        Matcher m = p.matcher(input);
        while (m.find()) {
            assert m.group().length() == 1;
            String word = m.group();
            this.words.add(word);
        }
    }

    @Override
    public Iterator<String> iterator() {
        WordList self = this;
        return new Iterator<String>() {
            private int index;
            boolean called = false;

            public boolean hasNext() {
                return index < self.words.size();
            }

            public String next() {
                this.called = false;
                return self.words.get(index++);
            }

            public void remove() {
                if (!this.called) {
                    throw new IllegalStateException();
                }
                self.words.remove(--index);

            }
        };
    }
}

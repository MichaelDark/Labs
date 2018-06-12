package ua.nure.temnokhud.task4;

import java.io.IOException;
import java.util.NoSuchElementException;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ua.nure.temnokhud.task4.Utility.readFile;

public class FileIterator implements Iterable<String> {
    private StringBuilder file;

    public FileIterator(String fileName) throws IOException {
        file = readFile(fileName);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Pattern patternWord = Pattern.compile("[\\w\\S]+", Pattern.UNICODE_CHARACTER_CLASS);
            Matcher matcher = patternWord.matcher(file);
            int currIndex = 1;

            @Override
            public boolean hasNext() {
                return matcher.find(currIndex);
            }

            @Override
            public String next() {
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                currIndex = matcher.end();
                return matcher.group();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

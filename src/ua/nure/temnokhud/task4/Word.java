package ua.nure.temnokhud.task4;

public class Word implements Comparable {
    private String content;
    private int frequency;

    public Word(String word) {
        this.content = word;
        this.frequency = 1;
    }

    public String getText() {
        return this.content;
    }
    public int getFrequency() {
        return this.frequency;
    }
    public void incrementFrequency() {
        this.frequency++;
    }

    @Override
    public int compareTo(Object o) {

        if (!(o instanceof Word)) {
            return -1;
        }
        Word word = (Word) o;
        int freq = word.getFrequency() - this.getFrequency();
        if (freq == 0){
            return this.getText().compareTo(word.getText());
        }
        return freq;

    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Word)) {
            return false;
        }
        Word word = (Word) o;
        return word.getText().equals(this.getText());
    }
}

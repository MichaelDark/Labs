package ua.nure.temnokhud.task4;

public class Part2 {
    private static final String FILE_NAME = "task42.txt";

    public static void main(String[] args) {
        WordContainer wc = new WordContainer(FILE_NAME);
        wc.sort();
        wc.print();
    }
}

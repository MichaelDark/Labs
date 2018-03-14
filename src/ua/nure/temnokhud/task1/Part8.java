package ua.nure.temnokhud.task1;

public class Part8 {

    ///Prints chess field NxM using Ч and Б
    ///@param1 - Height of field
    ///@param2 - Width of field
    public static void main(int... args) {
        if (args.length != 2) {
            System.out.println("Exception: Wrong input");
        }

        int height = args[0];
        int width = args[1];

        String[] chessField = getChessField(height, width);

        printChessField(height, width, chessField);
    }

    public static String[] getChessField(int height, int width) {
        String[] field = new String[height];
        for (int i = 0; i < height; i++) {
            field[i] = getLine(width, i % 2 == 0);
        }
        return field;
    }

    public static String getLine(int length, boolean startsWithCh) {
        char[] symbols = new char[] {'Ч', 'Б'};
        boolean currentSymbolIsCh = startsWithCh;
        String result = "";

        for (int i = 0; i < length; i++) {
            result += symbols[currentSymbolIsCh ? 0 : 1];
            currentSymbolIsCh = !currentSymbolIsCh;
        }
        return result;
    }

    public static void printChessField(int height, int width, String[] field) {
        System.out.println("ЧБ matrix " + height + "x" + width + ": ");
        for(String line : field) {
            System.out.println(line);
        }
        System.out.println();
    }
}

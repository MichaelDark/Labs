package ua.nure.temnokhud.task1;

import static ua.nure.temnokhud.task1.Utility.*;

class Part10 {
    private Part10() {}
    public static void main (String[] args) {
        Integer n;
        if (args.length < 1 || !isNumber(args[0])) {
            printWrongInputError();
            return;
        }
        n = Integer.parseInt(args[0]);
        if (!isNatural(n)) {
            printWrongInputError();
            return;
        }

        int[][] triangle = getPascalsTriangle(n);

        printPascalsTriangle(triangle);
    }
}

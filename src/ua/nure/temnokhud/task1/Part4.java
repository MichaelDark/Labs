package ua.nure.temnokhud.task1;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Utility.*;

class Part4 {
    private Part4() {
    }

    public static void main(String[] args) {
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

        int sum = sumOfRow(n);

        out.println(sum);
    }
}

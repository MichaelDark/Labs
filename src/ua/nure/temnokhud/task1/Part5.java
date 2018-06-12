package ua.nure.temnokhud.task1;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Utility.*;

class Part5 {
    private Part5() {
    }

    public static void main(String[] args) {
        Integer n;
        if (args.length < 1 || !isNumber(args[0])) {
            printWrongInputError();
            return;
        }
        n = Integer.parseInt(args[0]);
        if (!isNatural(n) || !isEven(n)) {
            printWrongInputError();
            return;
        }

        int count = getCountOfLuckyNumbers(n);

        out.println(count);
    }
}

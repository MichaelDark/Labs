package ua.nure.temnokhud.task1;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Functions.*;

class Part1 {
    private Part1() {
    }

    public static void main(String[] args) {
        Integer a, b;
        if (args.length < 2 || !isNumber(args[0]) || !isNumber(args[1])) {
            printWrongInputError();
            return;
        }
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        if (!isNatural(a) || !isNatural(b)) {
            printWrongInputError();
            return;
        }

        int result = getGreatestCommonDivisor(a, b);

        out.println(result);
    }
}
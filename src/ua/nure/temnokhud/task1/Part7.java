package ua.nure.temnokhud.task1;

import java.util.Arrays;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Functions.*;

class Part7 {
    private Part7() {
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

        int[] primeNumbers = getFirstPrimeNumbers(n);

        out.println(Arrays.toString(primeNumbers));
    }

}

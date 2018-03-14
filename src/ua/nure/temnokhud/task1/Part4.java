package ua.nure.temnokhud.task1;

public class Part4 {

    ///Sum of the following row
    ///1! - 2! + 3! - 4! + 5! ... +- N!
    ///@param - N
    public static void main (int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        int sum = sumOfRow(n);

        printSumOfRow(n, sum);
    }

    public static int sumOfRow(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }

        int factorial = 1;
        int res = 1;

        for (int i = 2; i <= n; i++) {
            factorial *= i;
            if (i % 2 == 1) {
                res += factorial;
            } else {
                res -= factorial;
            }
        }
        return res;
    }

    public static void printSumOfRow(int n, int sum) {
        System.out.println("Sum of a row (1!-2!+3!-4!...) for " + n +
                " is " + sum);
    }
}

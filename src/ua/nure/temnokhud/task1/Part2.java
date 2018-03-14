package ua.nure.temnokhud.task1;

public class Part2 {

    ///Sum of digits in a number
    ///@param - Number
    public static void main(int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        int result = sumOfDigits(n);

        printSumOfDigits(n, result);
    }

    public static int sumOfDigits(int a) {
        int res = 0;

        while (a > 0) {
            res += a % 10;
            a /= 10;
        }
        return  res;
    }

    public static void printSumOfDigits(int n, int sum) {
        System.out.println("Sum of digits for " +
                n +
                " is " + sum);
    }
}

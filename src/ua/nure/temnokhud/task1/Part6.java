package ua.nure.temnokhud.task1;

public class Part6 {

    ///Print first N Fibonacci numbers
    ///@param - N
    public static void main (int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        int[] fibonacciNumbers = getFibonacciNumbers(n);

        printFibonacciNumbers(fibonacciNumbers);
    }

    public static int[] getFibonacciNumbers(int count) {
        int[] fibNumbers = new int[count];
        int fib0 = 0;
        int fib1 = 1;

        for (int i = 0; i < count; i++) {
            fibNumbers[i] = fib1;
            int tmp = fib1;
            fib1 += fib0;
            fib0 = tmp;
        }
        return fibNumbers;
    }

    public static void printFibonacciNumbers(int[] fibNumbers) {
        System.out.println("First " + fibNumbers.length + " Fibonacci numbers: ");
        for (int fib : fibNumbers) {
            System.out.print(fib + " ");
        }
        System.out.println();
    }
}

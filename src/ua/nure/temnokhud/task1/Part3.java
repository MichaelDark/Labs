package ua.nure.temnokhud.task1;

public class Part3 {

    ///Check whether the number is prime
    ///@param - Number
    public static void main (int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        boolean isPrime = isPrimeNumber(args[0]);

        printIsPrimeOrNot(n, isPrime);
    }

    public static boolean isPrimeNumber(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n != i) {
                return false;
            }
        }
        return true;
    }

    public static void printIsPrimeOrNot(int n, boolean isPrime) {
        System.out.println(n + " is " + (isPrime ? "" : "NOT ") + "A PRIME number");
    }
}

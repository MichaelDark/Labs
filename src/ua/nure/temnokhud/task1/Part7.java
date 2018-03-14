package ua.nure.temnokhud.task1;

public class Part7 {

    ///Print first N Prime numbers
    ///@param - N
    public static void main (int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        int[] primeNumbers = getFirstPrimeNumbers(n);

        printFirstPrimeNumbers(primeNumbers);
    }

    public static int[] getFirstPrimeNumbers(int n) {
        int[] primeNumbers = new int[n];
        int index = 0;
        int number = 2;

        while (index < n) {
            if (isPrimeNumber(number)) {
                primeNumbers[index] = number;
                index++;
            }
            number++;
        }
        return primeNumbers;
    }

    public static void printFirstPrimeNumbers(int[] primeNumbers) {
        System.out.println("First " + primeNumbers.length + " Prime numbers: ");
        for (int primeNumber : primeNumbers) {
            System.out.print(primeNumber + " ");
        }
        System.out.println();
    }

    public static boolean isPrimeNumber(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n != i) {
                return false;
            }
        }
        return true;
    }
}

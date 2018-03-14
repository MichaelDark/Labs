package ua.nure.temnokhud.task1;

public class Part5 {

    ///Number of 'lucky' N-numbers
    ///@param - N
    public static void main (int... args) {
        if (args.length != 1) {
            System.out.println("Exception: Wrong input");
        }

        int n = args[0];

        long count = getCountOfLuckyNumbers(n);

        printCountOfLuckyNumbers(n, count);
    }

    public static long getCountOfLuckyNumbers(int n) {
        long res = 0;
        int half = n / 2;
        long minNumber = (long)Math.pow(10, half - 1);
        long maxNumber = (long)Math.pow(10, half);

        for (long i = minNumber; i < maxNumber; i++) {
            for (long j = 0; j < maxNumber; j++) {
                if (sumOfDigits(i) == sumOfDigits(j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void printCountOfLuckyNumbers(int n, long count) {
        System.out.println("The number of 'lucky' " + n + "-numbers is " + count);
    }

    public static int sumOfDigits(long a) {
        int res = 0;

        while (a > 0) {
            res += a % 10;
            a /= 10;
        }
        return res;
    }
}

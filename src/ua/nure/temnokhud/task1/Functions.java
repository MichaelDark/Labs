package ua.nure.temnokhud.task1;

import static java.lang.System.*;

class Functions {
    /**
     * Prints standard task header which includes caption and arguments
     */
    static void printHeader(String caption, String... args) {
        out.println();
        out.println("===" + caption + "===");
        out.println("Input: ");
        for(int i = 0; i < args.length; i++) {
            out.print(args[i] + " ");
        }
        if(args.length == 0) {
            out.print("-");
        }
        out.println();
        out.println("Output:");
    }

    /**
     * Prints wrong input error message
     */
    static void printWrongInputError() {
        out.println("Exception: Wrong input");
    }

    /**
     * Returns whether the string is a number or not
     */
    static boolean isNumber(String string) {
        return string.matches("[-+]?\\d+");
    }

    /**
     * Returns whether the number is a number or not
     */
    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Returns whether the number is natural or not
     */
    static boolean isNatural(int number) {
        return number > 1;
    }

    /**
     * Part1
     * Returns great common divisor for 2 numbers
     */
    static int getGreatestCommonDivisor(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    /**
     * Part2
     * Returns sum of digits of a number
     */
    static int sumOfDigits(int number) {
        int res = 0;

        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }

    /**
     * Part3
     * Returns whether the number is prime or not
     */
    static boolean isPrimeNumber(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Part4
     * Returns sum of the following row:
     * = 1! - 2! + 3! - 4! + 5! - ...
     */
    static int sumOfRow(int n) {
        if (n == 0) {
            return 0;
        }

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

    /**
     * Part5
     * Returns the number of N-digit lucky tickets
     */
    static int getCountOfLuckyNumbers(int n) {
        long time =  System.currentTimeMillis();
        int sum = 0;
        int half = n / 2;
        int[][] sums = new int[half + 1][half * 9 + 1];
        sums[0][0] = 1;

        for (int i = 1; i <= half; i++) {
            for (int j = 0; j <= i * 9; j++) {
                int tmp = 0;
                for (int k = 0; k < 10 && j - k >= 0; k++) {
                    tmp += sums[i - 1][j - k];
                }
                sums[i][j] = tmp;
            }
        }

        for (int i = 0; i <= (half - 1) * 9; i++) {
            sum += sums[half][i] * (sums[half][i] - sums[half - 1][i]);
        }
        for (int i = (half - 1) * 9 + 1; i < half * 9 + 1; i++) {
            sum += sums[half][i] * sums[half][i];
        }
        System.out.println("time" + (System.currentTimeMillis() - time));
        return sum;
    }

    /**
     * Part6
     * Returns first N Fibonacci numbers
     */
    static int[] getFibonacciNumbers(int count) {
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

    /**
     * Part7
     * Returns first N prime numbers
     */
    static int[] getFirstPrimeNumbers(int n) {
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

    /**
     * Part8
     * Returns chess field
     */
    static String[] getChessField(int height, int width, String black, String white) {
        String[] field = new String[height];
        StringBuilder lineNotEvenPattern = new StringBuilder();
        StringBuilder lineEvenPattern = new StringBuilder();

        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                lineNotEvenPattern.append(black);
                lineEvenPattern.append(white);
            } else {
                lineNotEvenPattern.append(white);
                lineEvenPattern.append(black);
            }
        }

        String lineNotEven = lineNotEvenPattern.toString();
        String lineEven = lineEvenPattern.toString();

        for (int i = 0; i < height; i += 2) {
            field[i] = lineNotEven;
        }
        for (int i = 1; i < height; i += 2) {
            field[i] = lineEven;
        }
        return field;
    }

    /**
     * Part9
     * Returns binary number
     */
    static int[] getArrayBinaryValue(int n, int length) {
        int[] binary = new int[length];
        for (int i = 0; i < length; i++) {
            binary[i] = n % 2;
            n /= 2;
        }
        return binary;
    }

    /**
     * Part10
     * Returns Pascals triangle
     */
    static int[][] getPascalsTriangle(int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
            result[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result;
    }

    /**
     * Part10
     * Prints Pascals triangle
     */
    static void printPascalsTriangle(int[][] triangle) {
        int length = triangle.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                out.printf("%3d ", triangle[j][i - j]);
            }
            out.println();
        }
        out.println();
    }

    /**
     * Part11
     * Sum of numbers in string
     */
    static int getSumFromString(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                res += Character.getNumericValue(ch);
            }
        }
        return res;
    }
}

package ua.nure.temnokhud.task1;

public class Part1 {

    ///Greatest common divisor
    ///@param1 - Number 1
    ///@param2 - Number 2
    public static void main(int... args) {
        if (args.length != 2) {
            System.out.println("Exception: Wrong input");
        }

        int a = args[0];
        int b = args[1];

        int result_recursive = gcdRecursive(a, b);
        int result_iterative = gcdIterative(a, b);

        printGCD(a, b, result_iterative, result_recursive);
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdRecursive(b, a % b);
    }

    public static int gcdIterative(int a, int b) {
        int tmp;

        while(b != 0) {
            tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public static void printGCD(int a, int b, int gcdIterative, int gcdRecursive) {
        System.out.println("Greatest common divisor for " +
                a + " and " + b +
                " is " + gcdIterative +
                " ( " + gcdRecursive + " )");
    }
}

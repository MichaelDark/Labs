package ua.nure.temnokhud.task1;

public class Part10 {

    ///Pascals triangle NxN
    ///@param - N
    public static void main (int... args) {
        int n = args[0];

        int[][] triangle = getPascalsTriangle(n);

        printPascalsTriangle(triangle);
    }

    public static int[][] getPascalsTriangle(int n) {
        int[][] result = new int[n][n];

        //init with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
            }
        }

        //init sides with 1
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
            result[i][0] = 1;
        }

        //calculations
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result;
    }

    public static void printPascalsTriangle(int[][] triangle) {
        int length = triangle.length;

        System.out.println("Pascals triangle " + length + "x" + length + ": ");
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[j][i - j] + " ");
            }
            System.out.println();
        }
    }
}

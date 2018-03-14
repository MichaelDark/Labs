package ua.nure.temnokhud.task1;

public class Part9 {

    ///5-dimensional array, filled from 1 to 32    0_0
    ///NO PARAMS O_O
    public static void main (int... args) {
        int[][][][][] array = new int[2][2][2][2][2];

        for (int i = 0; i < 32; i++) {
            int[] index = getIndexes(i);
            array[index[4]][index[3]][index[2]][index[1]][index[0]] = i + 1;
        }

        System.out.println("Array: ");
        for (int i = 0; i < 32; i++) {
            int[] index = getIndexes(i);
            System.out.println("array" +
                    "[" + index[4] + "]" +
                    "[" + index[3] + "]" +
                    "[" + index[2] + "]" +
                    "[" + index[1] + "]" +
                    "[" + index[0] + "]" +
                    array[index[4]][index[3]][index[2]][index[1]][index[0]]);
        }
        System.out.println();
    }

    public static int[] getIndexes(int n) {
        int[] indexes = new int[5];
        indexes[0] = n % 2;
        n /= 2;
        indexes[1] = n % 2;
        n /= 2;
        indexes[2] = n % 2;
        n /= 2;
        indexes[3] = n % 2;
        n /= 2;
        indexes[4] = n % 2;
        return indexes;
    }
}

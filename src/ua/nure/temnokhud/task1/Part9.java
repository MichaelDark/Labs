package ua.nure.temnokhud.task1;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Utility.*;

class Part9 {
    private Part9() {
    }

    public static void main() {
        long time = System.currentTimeMillis();
        int[][][][][] array = new int[2][2][2][2][2];
        int[][] ind = new int[32][5];

        for (int i = 0; i < 32; i++) {
            ind[i] = getArrayBinaryValue(i, 5);
            array[ind[i][4]][ind[i][3]][ind[i][2]][ind[i][1]][ind[i][0]] = i + 1;
        }

        for (int i = 0; i < 32; i++) {
            out.print(array[ind[i][4]][ind[i][3]][ind[i][2]][ind[i][1]][ind[i][0]] + " ");
        }
        System.out.println("time" + (System.currentTimeMillis() - time));
        out.println();
    }
}

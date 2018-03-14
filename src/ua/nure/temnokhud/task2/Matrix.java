package ua.nure.temnokhud.task2;

public class Matrix {

    public static void main(String... args) {
        Matrix matrix1 = new Matrix(new double[][]
                {{1,  2.4,  3.5},
                 {1,  6.32, 2.54},
                 {6,  8.2,  9.2},
                 {3,  2.3, 14.3}});
        Matrix matrix2 = new Matrix(new double[][]
                {{2,  9, 5.56},
                 {4,  8, 7.62},
                 {2,  5, 2.2},
                 {1,  4, 1.2}});
        Matrix matrix3 = new Matrix(new double[][]
                {{2,  9, 5.56, 4},
                 {4,  8, 7.62, 7},
                 {2,  5, 2.2,  5}});
        matrix1.print();
        matrix2.print();
        matrix3.print();
        matrix1.add(matrix2);
        matrix1.print();
        matrix1.mul(2);
        matrix1.print();
        matrix1.mul(matrix3);
        matrix1.print();
        matrix1.transpose();
        matrix1.print();
    }

    double[][] values;
    int rowCount;
    int colCount;

    public Matrix(double[][] ar) {
        values = ar;
        rowCount = ar.length;
        colCount = ar[0].length;
    }

    public int getRowCount() {
        return rowCount;
    }
    public int getColCount() {
        return colCount;
    }
    public double getValue(int row, int col) {
        return values[row][col];
    }
    public void setValue(int row, int col, double value) {
        values[row][col] = value;
    }

    public void add(Matrix matrix) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                values[i][j] += matrix.getValue(i, j);
            }
        }
    }
    public void mul(double x) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                values[i][j] *= x;
            }
        }
    }
    public void mul(Matrix matrix) {
        int newRowCount = rowCount;
        int newColCount = matrix.getColCount();
        int o = matrix.getRowCount();
        double[][] newValues = new double[newRowCount][newColCount];

        for (int i = 0; i < newRowCount; i++) {
            for (int j = 0; j < newColCount; j++) {
                for (int k = 0; k < o; k++) {
                    newValues[i][j] += values[i][k] * matrix.getValue(k, j);
                }
            }
        }
        values = newValues;
        rowCount = newRowCount;
        colCount = newColCount;
    }
    public void transpose() {
        double[][] newValues = new double[colCount][rowCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                newValues[j][i] = values[i][j];
            }
        }
        int tmp = rowCount;
        rowCount = colCount;
        colCount = tmp;
        values = newValues;
    }
    public void print() {
        System.out.printf("Matrix %dx%d:%n", rowCount, colCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.printf("%6.2f ", values[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}

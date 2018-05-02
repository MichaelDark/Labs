package ua.nure.temnokhud.task2;

import static java.lang.System.*;

class Matrix {

    public static void main(String... args) {
        Matrix m = new Matrix(new double[][] {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0}
        });

        Matrix m2 = new Matrix(new double[][] {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0}
        });

        System.out.println("~~~ m");
        m.print();

        System.out.println("~~~ m2");
        m2.print();

        System.out.println("~~~ transpose m");
        m.transpose();
        m.print();

        System.out.println("~~~ mul m on m2");
        m.mul(m2);
        m.print();

        System.out.println("~~~ mul m2 on 2");
        m2.mul(2);
        m2.print();
    }

    private double[][] values;
    private int rowCount;
    private int colCount;

    public Matrix(double[][] ar) {
        values = ar;
        rowCount = ar.length;
        colCount = ar[0].length;
    }
    public Matrix(int rows, int cols) {
        values = new double[rows][cols];
        rowCount = rows;
        colCount = cols;
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
        out.printf("Matrix %dx%d:%n", rowCount, colCount);
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                out.printf("%6.2f ", values[i][j]);
            }
            out.println();
        }
    }
}

package ua.nure.temnokhud.task2;

import static java.lang.System.*;

class Demo {

    private static final String[] EMPTY = {};

    public static void main(String[] args) {
        out.println();

        out.println("=== Circle performance ===");
        Circle.main(EMPTY);
        out.println();

        out.println("=== Matrix performance ===");
        Matrix.main(EMPTY);
        out.println();

        out.println("=== List performance ===");
        List.main(EMPTY);
        out.println();
    }
}

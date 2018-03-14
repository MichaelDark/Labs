package ua.nure.temnokhud.task2;

public class Demo {

    public static final String[] EMPTY = {};

    public static void main(String[] args) {
        System.out.println();

        System.out.println("=== Circle performance ===");
        Circle.main(EMPTY);
        System.out.println();

        System.out.println("=== Matrix performance ===");
        Matrix.main(EMPTY);
        System.out.println();

        System.out.println("=== List performance ===");
        MyList.main(EMPTY);
        System.out.println();
    }
}

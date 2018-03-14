package ua.nure.temnokhud.task1;

public class Demo {
    public static final int[] INT_EMPTY = {};
    public static final String[] STRING_EMPTY = {};

    public static void main(String[] args) {
        System.out.println();

        System.out.println("=== part 01 ===");
        Part1.main(39, 237);
        Part1.main(120, 90);
        System.out.println();

        System.out.println("=== part 02 ===");
        Part2.main(123456);
        Part2.main(101010);
        System.out.println();

        System.out.println("=== part 03 ===");
        Part3.main(71);
        Part3.main(72);
        System.out.println();

        System.out.println("=== part 04 ===");
        Part4.main(3);
        Part4.main(4);
        System.out.println();

        System.out.println("=== part 05 ===");
        Part5.main(6);
        System.out.println();

        System.out.println("=== part 06 ===");
        Part6.main(10);
        System.out.println();

        System.out.println("=== part 07 ===");
        Part7.main(10);
        System.out.println();

        System.out.println("=== part 08 ===");
        Part8.main(3, 5);
        System.out.println();

        System.out.println("=== part 09 ===");
        Part9.main(INT_EMPTY);
        System.out.println();

        System.out.println("=== part 10 ===");
        Part10.main(7);
        System.out.println();
    }
}

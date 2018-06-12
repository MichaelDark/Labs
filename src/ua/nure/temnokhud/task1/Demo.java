package ua.nure.temnokhud.task1;

import static ua.nure.temnokhud.task1.Utility.printHeader;

class Demo {
    public static void main(String[] args) {
        String[] input;

        input = new String[]{"39", "237"};
        printHeader("Part1", input);
        Part1.main(input);

        input = new String[] {"101010"};
        printHeader("Part2", input);
        Part2.main(input);

        input = new String[] {"71"};
        printHeader("Part3", input);
        Part3.main(input);

        input = new String[] {"4"};
        printHeader("Part4", input);
        Part4.main(input);

        input = new String[] {"10"};
        printHeader("Part5", input);
        Part5.main(input);

        input = new String[] {"10"};
        printHeader("Part6", input);
        Part6.main(input);

        input = new String[] {"10"};
        printHeader("Part7", input);
        Part7.main(input);

        input = new String[] {"3", "5"};
        printHeader("Part8", input);
        Part8.main(input);

        input = new String[] {};
        printHeader("Part9", input);
        Part9.main();

        input = new String[] {"10"};
        printHeader("Part10", input);
        Part10.main(input);

        input = new String[] {"fjkdg345b", "3d5s", "2k"};
        printHeader("Part11", input);
        Part11.main(input);

        input = new String[] {"dfjkgd@34asd", "$3F5X", "2k"};
        printHeader("Part12", input);
        Part12.main(input);
    }
}

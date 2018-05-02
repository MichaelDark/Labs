package ua.nure.temnokhud.task1;

import java.util.regex.Pattern;

import static java.lang.System.out;

class Part12 {
    private Part12() {
    }

    public static void main(String[] args) {
        StringBuilder resultPattern = new StringBuilder();
        Pattern pattern = Pattern.compile("[^a-zA-Z]");
        for (int i = 0; i < args.length; i++) {
            args[i] = pattern.matcher(args[i]).replaceAll("");
            resultPattern.append(args[i]);
        }

        out.println(resultPattern.toString());
    }
}
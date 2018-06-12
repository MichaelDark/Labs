package ua.nure.temnokhud.task1;

import java.util.regex.Pattern;

import static java.lang.System.out;
import static ua.nure.temnokhud.task1.Utility.getSumFromString;

class Part11 {
    private Part11() {
    }

    public static void main(String[] args) {
        //TODO:
        int resultPattern = 0;
        Pattern pattern = Pattern.compile("[^0-9]");
        for (int i = 0; i < args.length; i++) {
            args[i] = pattern.matcher(args[i]).replaceAll("");
            for (int j = 0; j < args[i].length(); j++) {
                resultPattern += Integer.parseInt(String.valueOf(args[i].charAt(j)));
            }
        }
        //TODO:

        //TODO:
        int resultFunc = 0;
        for (int i = 0; i < args.length; i++) {
            resultFunc += getSumFromString(args[i]);
        }

        //TODO:
        long time = System.currentTimeMillis();
        out.println(resultPattern + "; " + resultFunc);
    }
}
package ua.nure.temnokhud.task3;

import java.io.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.*;

class Part1 {

    public static void main(String... args) {
        List<String> fileText = readAllFileLines("Part1.txt", "UTF8");

        String buffer = fileText.get(0);
        Matcher m = Pattern.compile("[a-zA-Zа-яА-ЯёЁіІїЇ]").matcher(buffer);

        StringBuffer sb = new StringBuffer();
        int last = 0;
        while (m.find()) {
            m.appendReplacement(sb, m.group())
            sb.append(m.group(0).toUpperCase());
            last = m.end();
        }
        sb.append(buffer.substring(last));

        System.out.println(buffer.toString());

        System.out.println("Input before: ");
        printRows(fileText);

    }

    private static List<String> readAllFileLines(String filePath, String charset) {
        List<String> fileText = new ArrayList<String>();
        try {
            File fileDir = new File(filePath);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), charset));

            String str;

            while ((str = in.readLine()) != null) {
                fileText.add(str);
                System.out.println(str);
            }

            in.close();
        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        return fileText;
    }

    private static void printRows(String[] rows) {
        for(String row : rows) {
            System.out.println(row);
        }
    }

    private static void printRows(List<String> rows) {
        for(int i = 0; i < rows.size(); i++) {
            System.out.println(rows.get(i));
        }
    }

    private static String invertCase(String string) {
        char[] symbols = string.toCharArray();
        for (int i = 0; i < symbols.length; i++)
        {
            char c = symbols[i];
            if (isUpperCase(c))
            {
                symbols[i] = toLowerCase(c);
            }
            else if (isLowerCase(c))
            {
                symbols[i] = toUpperCase(c);
            }
        }
        return new String(symbols);
    }
}

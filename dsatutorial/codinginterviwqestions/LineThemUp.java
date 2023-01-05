package dsatutorial.codinginterviwqestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Kattis problem
public class LineThemUp {

    public static String lineThemUp(int num, String[] names) {

        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < num - 1; i++) {
            char[] name1 = names[i].toCharArray();
            char[] name2 = names[i + 1].toCharArray();
            int letterIndex = 0;
            char letter1 = name1[letterIndex];
            char letter2 = name2[letterIndex];
            while (letter1 == letter2) {
                letterIndex++;
                letter1 = name1[letterIndex];
                letter2 = name2[letterIndex];
            }
            if (letter1 > letter2)
                increasing = false;
            else
                decreasing = false;
        }
        if (increasing)
            return "INCREASING";
        if (decreasing)
            return "DECREASING";
        return "NEITHER";
    }

    public static void main(String[] args) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Giorgos\\Downloads\\samples\\1.in"));
            String line = reader.readLine();
            int num = Integer.parseInt(line);
            String[] names = new String[num];
            line = reader.readLine();
            int i = 0;
            while (line != null) {
                names[i] = line;
                System.out.println(names[i]);
                line = reader.readLine();
                i++;
            }
            String result = lineThemUp(num, names);
            System.out.println();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

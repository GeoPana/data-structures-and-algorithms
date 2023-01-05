package dsatutorial.codinginterviwqestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LindenMayorSystem {

    public static void lindenMayorSystem(String startingSequence, HashMap<String, String> rules, int numOfIterations) {
        if (numOfIterations == 0) {
            System.out.println(startingSequence);
            return;
        }

        String newSequence = "";
        for (int i = 0; i < startingSequence.length(); i++) {
            char current = startingSequence.charAt(i);
            newSequence = newSequence + rules.get(String.valueOf(current));
        }
        lindenMayorSystem(newSequence, rules, numOfIterations - 1);
    }

    public static void main(String[] args) {

        HashMap<String, String> rules = new HashMap<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Giorgos\\Downloads\\lindenmayorsystem\\sample.in"));
            String line = reader.readLine();
            String[] params = line.split(" ", 0);
            int numOfRules = Integer.parseInt(params[0]);
            int numOfIterations = Integer.parseInt(params[1]);


            for (int i = 1; i <= numOfRules; i++){
                line = reader.readLine();
                String[] rule = line.split(" -> ", 0);
                String initial = rule[0];
                String replace = rule[1];
                rules.put(initial, replace);
            }

            String startingSequence = reader.readLine();

            lindenMayorSystem(startingSequence, rules, numOfIterations);
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

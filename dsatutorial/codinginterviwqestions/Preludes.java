package dsatutorial.codinginterviwqestions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Preludes {

    public static void preludes(HashMap<String, String> map, ArrayList<String> scales) {
        for (int i = 0; i < scales.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + map.get(scales.get(i)));
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("A major", "UNIQUE");
        map.put("A# major", "Bb major");
        map.put("Bb major", "A# major");
        map.put("B major", "UNIQUE ");
        map.put("C major", "UNIQUE");
        map.put("C# major", "Db major");
        map.put("Db major", "C# major");
        map.put("D major", "UNIQUE");
        map.put("D# major", "Eb major");
        map.put("Eb major", "D# major");
        map.put("E major", "UNIQUE");
        map.put("F major", "UNIQUE");
        map.put("F# major", "Gb major");
        map.put("Gb major", "F# major");
        map.put("G major", "UNIQUE");
        map.put("G# major", "Ab major");
        map.put("Ab major", "G# major");
        map.put("A minor", "UNIQUE");
        map.put("A# minor", "Bb minor");
        map.put("Bb minor", "A# minor");
        map.put("B minor", "UNIQUE");
        map.put("C minor", "UNIQUE");
        map.put("C# minor", "Db minor");
        map.put("Db minor", "C# minor");
        map.put("D minor", "UNIQUE");
        map.put("D# minor", "Eb minor");
        map.put("Eb minor", "D# minor");
        map.put("E minor", "UNIQUE");
        map.put("F minor", "UNIQUE");
        map.put("F# minor", "Gb minor");
        map.put("Gb minor", "F# minor");
        map.put("G minor", "UNIQUE");
        map.put("G# minor", "Ab minor");
        map.put("Ab minor", "G# minor");

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\Giorgos\\Downloads\\chopin\\sample.in"));
            String line = reader.readLine();
            ArrayList<String> scales = new ArrayList<>();
            while (line != null) {
                scales.add(line);
                line = reader.readLine();
            }
            preludes(map, scales);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

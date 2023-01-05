package dsatutorial.codinginterviwqestions;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaries {

    public static String[] generateBinaries(int n) {
        String[] result = new String[n];
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = q.poll();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            q.offer(s1);
            q.offer(s2);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] binaries = generateBinaries(4);
        for (String str : binaries) {
            System.out.println(str);
        }
    }

}

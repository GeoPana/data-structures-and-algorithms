package dsatutorial.codinginterviwqestions;

import java.util.LinkedList;

public class Sim {
    /*
    Kattis problem
    --------------Sim-------------------
    This problem is an extension of another Kattis problem
    - backspace. In that problem, every time we see a
    character ‘<’, it actually means that the ‘Backspace’
    key is pressed and we undo the last character that was
    just typed.

    The extension is as follows: Now, pressing a ‘<’ (the
    ‘Backspace’ key) when the (typing) cursor is at the front
    of the line does nothing. Now if we see a character ‘[’, it
    actually means that the ‘Home’ key is pressed and we move
    the (typing) cursor to the front of the line. Similarly,
    if we see a character ‘]’, it actually means that the ‘End’
    key is pressed and we move the (typing) cursor the back of
    the line. For all other valid character in the input, it
    actually means that the corresponding key is pressed, we
    insert that character at the (typing) cursor position, and
    advance one position to the right the cursor accordingly.
    */

    public static String sim(String str) {
        LinkedList<Character> text = new LinkedList<>();
        char[] textArray = str.toCharArray();
        int index = 0;
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i] == '[') {
                index = 0;
            } else if (textArray[i] == ']') {
                index = text.size();
            } else if (textArray[i] == '<') {
                if (!text.isEmpty()) {
                    text.remove(index - 1);
                    index--;
                }
            } else {
                text.add(index, textArray[i]);
                index++;
            }
        }
        String result = "";
        for (char c : text) {
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        String testCase1 = "<<hate<<<<loves[steva<en ] cs2040c< and also cs2040c";
        System.out.println(sim(testCase1));
    }
}

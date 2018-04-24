package algs.strings;

import java.util.Map;

/**
 * @author Sergiy Levchynskyi
 */

public class CaesarCipher {

    static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(getNewChar(c, k));
        }
        return sb.toString();
    }

    private static char getNewChar(char c, int k) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }
        int base = Character.isLowerCase(c) ? 'a' : 'A';
        return (char)((c + k - base) % 26 + base);
    }

    public static void main(String[] args) {
        System.out.println(caesarCipher("middle-Outz", 2));
    }
}

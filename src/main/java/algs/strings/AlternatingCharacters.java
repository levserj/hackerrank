package algs.strings;

/**
 * @author Sergiy Levchynskyi
 */

public class AlternatingCharacters {

    static int alternatingCharacters(String s) {
        int count = 0;
        int i = 0;
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(i)) {
                count++;
            } else {
                i = j;
            }
        }
        return count;
    }
}

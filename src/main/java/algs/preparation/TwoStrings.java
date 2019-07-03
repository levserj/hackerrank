package algs.preparation;

import java.util.HashSet;
import java.util.Set;

public class TwoStrings {

    static String twoStrings(String s1, String s2) {
        Set<Character> smaller = stringToSetOfChar(s1);
        Set<Character> bigger = stringToSetOfChar(s2);
        if (smaller.size() > bigger.size()) {
            Set<Character> tmp = smaller;
            smaller = bigger;
            bigger = tmp;
        }
        for (Character c : smaller) {
            if (bigger.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    private static Set<Character> stringToSetOfChar(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add((c));
        }
        return set;
    }
}

package algs.strings;

import java.util.*;

/**
 * @author Sergiy Levchynskyi
 */

public class WeightedUniformStrings {

    private static final String YES = "YES";
    private static final String NO = "NO";

    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> weights = new HashSet<>();
        int lastLetterWeight = 0;
        int letterWeight = 0;
        int uniformLength = 1;
        for (int i = 0; i < s.length(); i++) {
            letterWeight = s.charAt(i) - 96;
            if (letterWeight == lastLetterWeight) {
                uniformLength++;
            } else {
                lastLetterWeight = letterWeight;
                uniformLength = 1;
            }
            weights.add(letterWeight * uniformLength);
        }
        List<String> result = new ArrayList<>();
        for (int q : queries) {
            result.add(weights.contains(q) ? YES : NO);
        }
        return result.toArray(new String[]{});
    }
}

package algs.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sergiy Levchynskyi
 */

public class Gemstones {

    static int gemstones(String[] arr) {
        int count = 0;
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        StringBuilder noDuplicates = new StringBuilder();
        for (int i = 0; i < arr[0].length(); i++) {
            if (noDuplicates.toString().indexOf(arr[0].charAt(i)) == -1) {
                noDuplicates.append(arr[0].charAt(i));
            }
        }
        String possibleGems = noDuplicates.toString();
        outer:
        for (int i = 0; i < possibleGems.length(); i++) {
            for (String s : arr) {
                if (s.indexOf(possibleGems.charAt(i)) == -1) {
                    continue outer;
                }
            }
            count++;
        }
        return count;
    }
}

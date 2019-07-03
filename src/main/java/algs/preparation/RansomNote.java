package algs.preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineMap = new HashMap<>();
        Map<String, Integer> noteMap = new HashMap<>();
        Arrays.stream(magazine).forEach(existingWord -> putAndIncrementValue(magazineMap, existingWord));
        Arrays.stream(note).forEach(neededWord -> putAndIncrementValue(noteMap, neededWord));
        String result = "Yes";
        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
            Integer neededWordcount = entry.getValue();
            Integer existingWordCount = magazineMap.get(entry.getKey());
            if (existingWordCount == null || existingWordCount < neededWordcount) {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

    private static void putAndIncrementValue(Map<String, Integer> map,  String key) {
        Integer counter = map.get(key);
        if (counter == null || counter < 1) {
            counter = 0;
        }
        map.put(key, counter + 1);
    }

    public static void main(String[] args) {
        String[] magazine = {"give", "me", "one", "grand", "today", "night"};
        String[] note = {"give", "one", "grand", "today"};
        checkMagazine(magazine, note);
    }

}

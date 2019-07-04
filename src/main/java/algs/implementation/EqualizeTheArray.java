package algs.implementation;

import java.util.*;

public class EqualizeTheArray {

    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> counted = new HashMap<>();
        Arrays.stream(arr).boxed()
                .forEach(number -> counted.put(number, counted.getOrDefault(number, 0) + 1));

        return arr.length - Collections.max(counted.entrySet(), Comparator.comparing(Map.Entry::getValue)).getValue();
    }

}

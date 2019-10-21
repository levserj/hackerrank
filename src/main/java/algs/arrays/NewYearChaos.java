package algs.arrays;

import java.util.HashMap;
import java.util.Map;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int swaps = 0;
        String result = null;
        Map<Integer, Integer> mapValueIndex = new HashMap<>();
        for (int i = 0; i < q.length; i++) {
            mapValueIndex.put(q[i], i + 1);
        }
        for (int i = 0; i < q.length; i++) {
            if (q[i] != i + 1) {
                int diffInPosition = mapValueIndex.get(q[i]) - i;
                if (diffInPosition > 2) {
                    result = "Too chaotic";
                    break;
                }
                swaps += diffInPosition;
            }
        }
        if (null == result) {
            result = String.valueOf(swaps);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
    }
}

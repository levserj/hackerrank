package algs.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sergiy Levchynskyi
 */

public class CutTheSticks {

    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        result.add(arr.length);
        for (int i = 0; i < arr.length; ) {
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++;
            }
            i++;
            if (arr.length != i) {
                result.add(arr.length - i);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        cutTheSticks(new int[]{5, 4, 4, 2, 2, 8});
    }
}

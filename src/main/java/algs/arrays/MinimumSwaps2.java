package algs.arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        int count = 0;
        Map<Integer, Integer> mapValueIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mapValueIndex.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int swapB = mapValueIndex.get(i + 1);
                swapAndGetCount(arr, i, swapB, mapValueIndex);

                count++;
            }
        }
        return count;

    }

    private static void swapAndGetCount(int[] arr, int swapA, int swapB, Map<Integer, Integer> mapValueIndex) {
        mapValueIndex.put(arr[swapA], swapB);
        mapValueIndex.put(arr[swapB], swapA);
        int temp = arr[swapA];
        arr[swapA] = arr[swapB];
        arr[swapB] = temp;

    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
        System.out.println(minimumSwaps(new int[]{2, 3, 4, 1, 5}));
    }
}

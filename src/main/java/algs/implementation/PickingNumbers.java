package algs.implementation;

import java.util.Arrays;

/**
 * @author Sergiy Levchynskyi
 */

public class PickingNumbers {

    static int pickingNumbers(int[] a) {
        Arrays.sort(a);
        int count = 1;
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            int countT = 1;
            int iNext = i;
            while (j < a.length && a[j] - a[i] < 2) {
                if (a[j] - a[i] == 1 && iNext == i) {
                    iNext = j - 1;
                }
                countT++;
                j++;
            }
            i = iNext;
            if (countT > count) {
                count = countT;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(pickingNumbers(new int[]{
                /*1,1,1,2,2,2,2,3,3*/
                4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2, 3, 98, 98, 1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2, 1, 1, 9, 2, 4}));
    }

}

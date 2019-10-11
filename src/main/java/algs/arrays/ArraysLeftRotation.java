package algs.arrays;

import java.util.Arrays;

public class ArraysLeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int [] result = new int[a.length];
        System.arraycopy(a, d, result, 0, a.length - d);
        System.arraycopy(a, 0,result,a.length - d, d);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotLeft(new int[]{1,2,3,4,5}, 4)));
    }
}

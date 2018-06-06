package algs.implementation;

import java.util.Arrays;

/**
 * @author Sergiy Levchynskyi
 */

public class ServiceLane {

    static int[] serviceLane(int n, int[][] cases, int[] width) {
        int[] result = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            result[i] = Arrays.stream(Arrays.copyOfRange(width, cases[i][0], cases[i][1] + 1)).min().getAsInt();
        }
        return result;
    }

    public static void main(String[] args) {
        serviceLane(1, new int[][]{{2, 3}, {1, 4}, {2, 4}, {2, 4}, {2, 3}}, new int[]{1, 2, 2, 2, 1});
    }
}

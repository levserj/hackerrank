package algs.implementation;

import java.util.Arrays;

/**
 * @author Sergiy Levchynskyi
 */

public class TheHurdleRace {
    static int hurdleRace(int k, int[] height) {
        Arrays.sort(height);
        int max = height[height.length - 1];
        return max > k ? max - k : 0;
    }
}

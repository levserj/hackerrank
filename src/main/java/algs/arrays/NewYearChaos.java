package algs.arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int swaps = 0;
        String result = null;

        for (int i = q.length - 1; i >= 0; i--) {
            int diffInPosition = q[i] - (i + 1);
            if (diffInPosition > 2) {
                result = "Too chaotic";
                break;
            }

            for (int j = Math.max(q[i] - 2, 0); j < i; j++) {
                if (q[j] > q[i]) {
                    swaps++;
                }
            }

        }
        if (null == result) {
            result = String.valueOf(swaps);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4});
        minimumBribes(new int[]{2, 5, 1, 3, 4});
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4});
        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
    }
}

package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class AppendAndDelete {

    private static final String YES = "Yes";
    private static final String NO = "No";

    static String appendAndDelete(String s, String t, int k) {
        int sl = s.length();
        int tl = t.length();
        int samePrefix = 0;
        int diffSuffixSum = 0;
        for (int i = 0; i < sl && i < tl; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                samePrefix++;
            } else {
                break;
            }
        }
        diffSuffixSum = sl + tl - 2 * samePrefix;
        if (diffSuffixSum > k) {
            return NO;
        } else if (diffSuffixSum % 2 == k % 2 || sl + tl <= k) {
            return YES;
        }
        return NO;
    }

    public static void main(String[] args) {
//        System.out.println(appendAndDelete("hackerhappy", "hackerrank", 9));
//        System.out.println(appendAndDelete("ashley", "ash", 2));
        System.out.println(appendAndDelete("qwerasdf", "qwerbsdf", 6));

    }
}

package algs.strings;

import java.util.Arrays;

/**
 * @author Sergiy Levchynskyi
 */

public class CircularPalindromes {

    // TODO: 26.04.18 Optimise - not passing tests by time

    static int[] circularPalindromes(String s) {
        int[] palindromes = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            palindromes[i] = getLongestPalindrome(rotated);
        }
        return palindromes;
    }

    private static int getLongestPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int longestPalindrome = s.length() == 0 ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int tmpLength = getPalindromeLength(i - 1, i + 1, s, 0);
            if (longestPalindrome < tmpLength) {
                longestPalindrome = tmpLength;
            }
            if (s.charAt(i) == s.charAt(i - 1)) {
                tmpLength = getPalindromeLength(i - 2, i + 1, s, 0);
            }
            if (longestPalindrome < tmpLength) {
                longestPalindrome = tmpLength;
            }
        }
        return longestPalindrome;
    }

    private static int getPalindromeLength(int left, int right, String s, int length) {
        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return length;
        }
        length = right - left + 1;
        return getPalindromeLength(--left, ++right, s, length);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularPalindromes("aaaaabbbbaaaa")));
    }
}

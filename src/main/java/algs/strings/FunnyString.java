package algs.strings;

/**
 * @author Sergiy Levchynskyi
 */

public class FunnyString {

    private static final String FUNNY = "Funny";
    private static final String NOT_FUNNY = "Not Funny";

    static String funnyString(String s) {
        int l = s.length();
        for (int i = 0; i < l / 2; i++) {
            if (Math.abs(s.charAt(i + 1) - s.charAt(i)) != Math.abs(s.charAt(l -1 -i) - s.charAt(l - 2 - i))) {
                return NOT_FUNNY;
            }
        }
        return FUNNY;
    }

    public static void main(String[] args) {
        System.out.println(funnyString("acxz"));
        System.out.println(funnyString("bcxz"));
    }
}

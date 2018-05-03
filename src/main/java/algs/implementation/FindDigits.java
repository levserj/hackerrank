package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class FindDigits {

    static int findDigits(int n) {
        int count = 0;
        int t = n;
        while (t > 0) {
            if (t % 10 != 0 && n % (t % 10) == 0) {
                count++;
            }
            t = t / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findDigits(1012));
    }
}

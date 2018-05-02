package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class BeautifulDaysAtTheMovies {

    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        StringBuilder sb  = new StringBuilder();
        for (int n = i; n <= j; n++) {
            int r = Integer.valueOf(sb.append(n).reverse().toString());
            if (Math.abs(n - r) % k == 0) {
                count++;
            }
            sb.delete(0, sb.length());
        }
        return count;
    }
}

package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class DrawingBook {
    static int pageCount(int n, int p) {
        int pages = 0;
        if (p == 1 || p == n || (n % 2 == 1 && p > n - 2)) {
            return pages;
        }
        if (p <= n / 2) {
            pages = p / 2;
        } else {
            if (n % 2 == 0) {
                pages = (n - p + 1) / 2;
            } else {
                pages = (n - p) / 2;
            }
        }
        return pages;
    }

    public static void main(String[] args) {
        System.out.println(pageCount(8, 3));
    }
}

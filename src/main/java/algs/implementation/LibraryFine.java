package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class LibraryFine {

    private final static int OVER_YEAR = 10_000;
    private final static int OVER_MONTH = 500;
    private final static int SAME_MONTH = 15;

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y2 < y1) {
            return OVER_YEAR;
        } else if (m2 < m1 && y1 == y2) {
            return (m1 - m2) * OVER_MONTH;
        } else if (d2 < d1 && m1 == m2 && y2 == y1) {
            return (d1 - d2) * SAME_MONTH;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(libraryFine(28, 2, 2015, 15, 4, 2015));
    }
}

package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class SherlockAndSquares {

    static int squares(int a, int b) {
        int count = 0;
        int currentSquare = 0;
        for (int i = a; i <= b; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt % (int) sqrt == 0) {
                count++;
                currentSquare = (int) sqrt;
                currentSquare++;
                while (Math.pow(currentSquare, 2) <= b) {
                    count++;
                    currentSquare++;
                }
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(squares(3,9));
    }
}

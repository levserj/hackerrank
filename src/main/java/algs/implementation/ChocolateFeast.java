package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class ChocolateFeast {

    static int chocolateFeast(int n, int c, int m) {
        int eats = n / c;
        return getTotalChocolates(eats, eats, m);
    }

    private static int getTotalChocolates(int eats, int wrappers, int promo) {
        int promoChocalates = wrappers / promo;
        int wrappersLeft = wrappers % promo;
        return promoChocalates > 0 ?
                getTotalChocolates(eats + promoChocalates, promoChocalates + wrappersLeft, promo) :
                eats;
    }

    public static void main(String[] args) {
        System.out.println(chocolateFeast(6,2,2));
    }
}

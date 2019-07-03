package algs.strings;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long reminder = n % s.length();
        long repeatedTimes = n / s.length();
        return repeatedTimes * countAOccurence(s) + countAOccurence(s.substring(0, Math.toIntExact(reminder)));

    }

    private static long countAOccurence(String s) {
        return s.length() - s.replaceAll("a", "").length();
    }

}

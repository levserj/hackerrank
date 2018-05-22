package algs.implementation;

/**
 * @author Sergiy Levchynskyi
 */

public class ACMICPCTeam {

    static int[] acmTeam(String[] topic) {
        int maxTopics = 0;
        int maxTeams = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                int bitCount = 0;
                for (int k = 0; k < topic[0].length(); k++) {
                    if (topic[i].charAt(k) == '1' || topic[j].charAt(k) == '1') {
                        bitCount++;
                    }
                }
                if (bitCount > maxTopics) {
                    maxTopics = bitCount;
                    maxTeams = 1;
                } else if (bitCount == maxTopics) {
                    maxTeams++;
                }
            }
        }
        return new int[]{maxTopics, maxTeams};
    }

    public static void main(String[] args) {
        acmTeam(new String[] {
                "10101",
                "11100",
                "11010",
                "00101"
        });
    }

}

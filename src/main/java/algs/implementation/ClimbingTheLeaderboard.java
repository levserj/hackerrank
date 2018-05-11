package algs.implementation;

import java.util.*;

/**
 * @author Sergiy Levchynskyi
 */

public class ClimbingTheLeaderboard {

    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        List<Integer> rankAndScore = new ArrayList<>();
        rankAndScore.add(scores[0]);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i -1] != scores[i]){
                rankAndScore.add(scores[i]);
            }
        }
        int currentRank = rankAndScore.size();
        for (int j = 0; j < alice.length; j++) {
            while (currentRank > 0 && rankAndScore.get(currentRank - 1) <= alice[j]) {
                currentRank--;
            }
            result[j] = currentRank + 1;
        }
        return result;
    }

}

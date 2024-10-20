package LeetCode;

import java.util.*;

public class Day3 {
    public static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> winner = new HashMap<>();
        HashMap<Integer, Integer> loser = new HashMap<>();
        for (int[] match : matches) {
            winner.put(match[0], winner.getOrDefault(winner.get(match[0]), 0) + 1);
            loser.put(match[1], loser.getOrDefault(loser.get(match[1]), 0) + 1);
        }
        List<Integer> noLossPlayer = new ArrayList<>();
        List<Integer> exactlyOneLossPlayer = new ArrayList<>();

        for (int player : winner.keySet()) {
            int winCount = winner.get(player);
            int lossCount = loser.getOrDefault(player, 0);

            if (winCount > 0) {
                if (lossCount == 0) {
                    noLossPlayer.add(player);
                }
            } else if (lossCount == 1) {
                exactlyOneLossPlayer.add(player);
            }
        }
        Collections.sort(noLossPlayer);
        Collections.sort(exactlyOneLossPlayer);

        List<List<Integer>> result = new ArrayList<>();
        result.add(noLossPlayer);
        result.add(exactlyOneLossPlayer);

        return result;
    }
}

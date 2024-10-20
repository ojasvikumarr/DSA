package LeetCode;

import java.util.*;

public class Day1 {
    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        int steps = 0;
        for (int count : map.values()) {
            steps += Math.abs(count);
        }
        return steps / 2;
    }
}

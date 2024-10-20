package LeetCode;

import java.util.*;

public class Day2 {

    // public boolean closeStrings(String word1, String word2) {
    // if (word1.length() != word2.length()) {
    // return false;
    // }
    // HashMap<Character, Integer> map1 = countCharacters(word1);
    // HashMap<Character, Integer> map2 = countCharacters(word2);

    // }

    public static HashMap<Character, Integer> countCharacters(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }

    public static void compareCounts(HashMap<Character, Integer> map1HashMap, HashMap<Character, Integer> map2) {
        // for (HashMap.Enter<Character, Integer> entry : map1.entrySet()) {
        // char ch = entry.getKey();
        // int count = entry.getValue();
        // if (!map2.containsKey(ch) || map2.get(ch) != count) {
        // return false;
        // }
        // }
    }
}

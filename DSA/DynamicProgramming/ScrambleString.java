package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
    class Solution {

    Map<String, Boolean> mp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (s2.length() != n)
            return false;
        if (s1.equals(s2))
            return true;
        if (n == 1)
            return false;

        String key = s1 + " " + s2;
        if (mp.containsKey(key))
            return mp.get(key);
        for (int i = 1; i < n; i++) {
            boolean withoutswap = (
                    isScramble(s1.substring(0, i), s2.substring(0, i))
                            &&
                            isScramble(s1.substring(i), s2.substring(i))
            );
            if (withoutswap) {
                mp.put(key, true);
                return true;
            }
            boolean withswap = (
                    isScramble(s1.substring(0, i), s2.substring(n - i))
                            &&
                            isScramble(s1.substring(i), s2.substring(0, n - i))
            );

            if (withswap) {
                mp.put(key, true);
                return true;
            }
            
        }
        mp.put(key, false);
        return false;
    }
}
}

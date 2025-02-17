package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Day133 {
    class Solution {
    public int numTilePossibilitiesII(String tiles) {
        //subset problem 
        //We'll solve 
        int n = tiles.length();
        int total = (1<<n)-1 ; 
        Set<String> set = new HashSet<>();
        for(int mask = 1 ; mask <= total ; mask++){
            //we traverse the mask 
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                if((mask & (1<<i)) != 0){
                    //This means the bit is set 
                    sb.append(tiles.charAt(i));
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }


    public int numTilePossibilities(String tiles) {
        // Track frequency of each uppercase letter (A-Z)
        int[] charCount = new int[26];
        for (char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }

        // Find all possible sequences using character frequencies
        return findSequences(charCount);
    }

    private int findSequences(int[] charCount) {
        int totalCount = 0;

        // Try using each available character
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }

            // Add current character and recurse
            totalCount++;
            charCount[pos]--;
            totalCount += findSequences(charCount);
            charCount[pos]++;
        }

        return totalCount;
    }
}

}

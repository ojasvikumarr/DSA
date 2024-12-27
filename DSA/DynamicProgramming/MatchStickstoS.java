package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MatchStickstoS {
    class Solution {
    Map<String, Boolean> memo;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        int maxi = 0;
        for (Integer matches : matchsticks) {
            sum += matches;
            maxi = Math.max(maxi, matches);
        }
        int target = sum / 4;
        if (sum % 4 != 0 || maxi > target)
            return false;
        // We assume of having 4 sides that needs to be filled with sides
        long[] sides = new long[4];

        memo = new HashMap<>();
        Arrays.sort(matchsticks); // Sort in ascending order
        //then sort in descending order
        //so that we can catch the big numbers first and rule them out of the tree 
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return dfs(matchsticks, sides, 0, target);
    }



    public boolean dfs(int[] arr, long[] sides, int idx, int target) {
        ////////BASE condition of checking whther all the sides are same or not 
        if (idx == arr.length) {
            if (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]) {
                return true;
            } else {
                return false;
            }
        }
        // String key =
        // Arrays.toString(Arrays.stream(sides).sorted().toArray());-----Dropping this
        // as TLe because of sorting complexity
        String key = sides[0] + "," + sides[1] + "," + sides[2] + "," + sides[3];
        //Converting long to string use double quotes as single quotes will give error
        if (memo.containsKey(key))
            return memo.get(key);

        for (int i = 0; i < 4; i++) {
            // -- optimization 1
            if (sides[i] + arr[idx] > target)
                continue;

            // -- optimization 2
            int j = i - 1;
            while (j >= 0) {
                if (sides[j] == sides[i])
                    break;
                j = j - 1;
            }
            if (j != -1)
                continue;
            //this checks whether the pattern is calculated earlier or not 
            //--if yes then no need to calculate further 
            sides[i] += arr[idx];
            if (dfs(arr, sides, idx + 1, target)) {
                memo.put(key, true);
                return true;
            }
            sides[i] -= arr[idx];
        }
        memo.put(key, false);
        return false;
    }

    
}
}

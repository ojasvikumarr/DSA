import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Day47 {
    class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> patFreq = new HashMap<>();
        
        for (int[] row : mat) {
            StringBuilder pattern = new StringBuilder(null);
            if (row[0] == 0) {
                for (int bit : row) pattern.append(bit);
            } else {
                for (int bit : row) pattern.append(bit ^ 1);
            }
            patFreq.merge(pattern.toString(), 1, Integer::sum);
        }
        
        return Collections.max(patFreq.values());
    }
}
}

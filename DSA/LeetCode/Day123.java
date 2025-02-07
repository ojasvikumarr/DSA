package LeetCode ;
import java.util.* ; 

public class Day123 {
    class Solution {
        public int[] queryResultsII(int n, int[][] queries) {
            int[] balls = new int[n+1];
            Arrays.fill(balls , -1);
    
            int m = queries.length ;
            int[] result = new int[m];
    
            Map<Long , Long> map = new HashMap<>();
    
            long distinct = 0 ; 
            for(int i = 0 ; i < m ; i++){
                int[] query = queries[i];
                int x = query[0];
                long y = query[1];
    
                long prevColor = balls[x];
    
                balls[x] = (int)y ; 
    
                if(prevColor != -1){
                    map.put(prevColor , map.get(prevColor)-1 ) ; 
                    if(map.get(prevColor) == 0){
                        //WE have reduction in distinct colors ;
                        distinct-- ;
                    }
                }
                map.put(y , map.getOrDefault(y , (long)0) + 1);
                if(map.get(y) == 1){
                    //That means we have a new color ; 
                    distinct++ ; 
                }
    
                result[i] = (int)distinct ; 
            }
            return result ; 
        }
    
        public int[] queryResults(int limit, int[][] queries) {
            int n = queries.length;
            int[] result = new int[n];
            Map<Integer, Integer> colorMap = new HashMap<>();
            Map<Integer, Integer> ballMap = new HashMap<>();
    
            // Iterate through queries
            for (int i = 0; i < n; i++) {
                // Extract ball label and color from query
                int ball = queries[i][0];
                int color = queries[i][1];
    
                // Check if ball is already colored
                if (ballMap.containsKey(ball)) {
                    // Decrement count of the previous color on the ball
                    int prevColor = ballMap.get(ball);
                    colorMap.put(prevColor, colorMap.get(prevColor) - 1);
    
                    // If there are no balls with previous color left, remove color from color map
                    if (colorMap.get(prevColor) == 0) {
                        colorMap.remove(prevColor);
                    }
                }
                // Set color of ball to the new color
                ballMap.put(ball, color);
    
                // Increment the count of the new color
                colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
    
                result[i] = colorMap.size();
            }
            return result;
        
    }
    
    }
}

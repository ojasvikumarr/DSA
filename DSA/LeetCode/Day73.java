public class Day73 {
    class Solution {
        public long findScoreI(int[] nums) {
            // ArrayList<Integer> ls = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(Integer it : nums){
                // ls.add(it);
                pq.add(it);
            }
            int n = nums.length ;
            long score = 0 ;
            while(!pq.isEmpty()){
                int num = pq.poll();
                for(int i = 0 ; i < n ; i++){
                    if(nums[i] == num){
                        if(i > 0) nums[i-1] = -1;
                        score += nums[i];
                        nums[i] = -1 ;
                        if(i < n-1) nums[i+1] = -1;
                    }
                }
            }
            return score ;
        }
    
    
        public long findScoreII(int[] nums) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                pq.add(new int[]{nums[i], i});
            }
    
            boolean[] visited = new boolean[n];
            long score = 0;
    
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int value = current[0];
                int index = current[1];
                if (visited[index]) continue;
                score += value;
                visited[index] = true;
                if (index > 0) visited[index - 1] = true;
                if (index < n - 1) visited[index + 1] = true;
            }
    
            return score;
        }
        public long findScore(int[] nums) {
            int n = nums.length;
            int[][] dp = new int[n][2];
    
            for (int i = 0; i < n; i++) {
                dp[i][0] = nums[i];
                dp[i][1] = i;
            }
    
            Arrays.sort(dp, (a, b) -> a[0] - b[0]);
    
            boolean[] marked = new boolean[n];
            long result = 0;
    
            for (int[] arr : dp) {
                int val = arr[0];
                int ind = arr[1];
    
                if (!marked[ind]) {
                    result += val;
    
                    marked[ind] = true;
                    if (ind > 0)
                        marked[ind - 1] = true;
                    if (ind < n - 1) 
                        marked[ind + 1] = true;
                }
            }
    
            return result;
        }
    }
    
}

class Solution {
    public int maxValue(int[][] events, int k) {
        // WHY NO GREEDY??
        // If i go for the largest meeting for example , it allowed to go in two 
        // largest meetings but i had an option to go to 4 small meetings but there cumulative
        // value was greater than that of greedy part 
        // So greedy wont be giving correct always Right 
        // so if i tend to attend a meeting then my goal will that i 
        // have to explore all other meetings that are feasible with my current meeting 
        // so there will be an option if i pick a meeting , then other 
        // meetings will be picked and not picked so on.. it becomes a sub problem 
        int n = events.length ;
        Arrays.sort(events , (a , b) -> a[0] - b[0]);
        //i will increase the index till the point that , meetings starts from the prev meeting end
        dp = new int[n+1][k+1];
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(events , 0 , k);
    }
    int[][] dp ; 
    public int solve(int[][] events, int idx , int k ){
        int n = events.length ;
        if(idx == n || k == 0){
            return 0;
        }
        if(dp[idx][k] != -1){
            return dp[idx][k];
        }
        int pick = 0 ; 
            // int i = idx+1 ; 
            // for(; i < n ; i++){
            //     if(events[i][0] > events[idx][1]) break ;
            // }
            // pick = events[idx][2] + solve(events , i , k-1);
            int nextIdx = BinarySearch(events , events[idx][1]);
            pick = events[idx][2] + solve(events , nextIdx , k-1);
        int skip = solve(events , idx+1 , k);
        return dp[idx][k] = Math.max(pick , skip);
    }
    public int BinarySearch(int[][] events , int target){
        int l = 0 ; 
        int r = events.length ; 
        while(l < r){
            int mid = l + (r-l)/2 ; 
            if(events[mid][0]<= target){
                l = mid +1 ; 
            }else{
                r = mid ; 
            }
        }
        return l ;
    }
}
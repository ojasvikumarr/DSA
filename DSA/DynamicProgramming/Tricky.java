package DynamicProgramming;

public class Tricky {
    class Solution {
        class Pair{
            int num ;
            int sum ; 
            public Pair(int n , int s){
                this.num = n ; 
                this.sum = s ;
            }
        }
        public int deleteAndEarn(int[] nums) {
            // TreeMap<Integer , Integer> map = new TreeMap<>();
            // Arrays.sort(nums);
            // int sum = 0 ; 
            // int n = nums.length ; 
    
            // PriorityQueue<Pair> buckets = new PriorityQueue<>((a , b) -> (b.num - a.num));
    
            // for(int i = 0 ; i < n ; i++){
            //     if(i > 0 && nums[i] != nums[i-1]){
            //         buckets.add(new Pair(nums[i-1] , sum));
            //         sum = 0 ; 
            //     }
            //     sum += nums[i];
            // }
            // buckets.add(new Pair(nums[n-1] , sum));
    
            int n = 10001 ; 
            int[] values = new int[n];
            for(int num : nums){
                values[num] += num ; 
            }
    
            int take = 0 ; 
            int skip = 0 ; 
            for(int i = 0 ; i < n ; i++){
                int takei = skip + values[i];
                int skipi = Math.max(skip , take);
                take = takei  ;
                skip = skipi  ; 
            }
    
            int[] buckets = new int[10001];
            for(int num : nums) buckets[num] += num ; 
    
            int[] dp = new int[10001];
            dp[0] = buckets[0];
            dp[1] = buckets[1];
            for(int i = 2 ; i < buckets.length ; i++){
                dp[i] = Math.max(buckets[i] + dp[i-2] , dp[i-1]);
            }
            return dp[buckets.length-1];
            // return Math.max(take , skip);
            // return solve(values , 0);
        }
    
        public int solve(int[] buckets , int idx ){
            if(idx >= 10001){
                return 0 ;
            }
            int pick = buckets[idx] + solve(buckets , idx+2);
            int notpick = solve(buckets , idx+1);
            return Math.max(pick , notpick);
        }
        // public int solve(PriorityQueue<Pair> buckets , int idx){
    
        //     int largestSum = buckets.get(idx).sum ; 
        //     int plusSum = 0 ;
        //     if(idx+1 < buckets.size()){
        //         if(buckets.get(idx+1).num == buckets.get(idx).num+1)
        //         plusSum = buckets.get(idx+1).sum ; 
        //     }
        //     int minusSum = 0 ;
        //     if(idx-1 >= 0){
        //         if(buckets.get(idx+1).num == buckets.get(idx).num-1)
        //         minusSum = buckets.get(idx-1).sum ; 
        //     } 
        //     int maxi = 0 ; 
        //     if(largestSum > plusSum && largestSum > minusSum){
        //         //We'll remove the neighbors and earn the largest Sum 
        //         buckets.remove()
        //         maxi = largestSum + solve(buckets , idx);
        //     }else if(plusSum > largestSum && plusSum > minusSum){
        //         maxi = plusSum + solve(buckets , idx);
        //     }else{
        //         maxi = minusSum + solve(buckets , idx);
        //     }
    
        //     return maxi ; 
        // }
    }
}

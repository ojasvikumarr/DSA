public class Day250{
class Solution {
    public long maximumProduct(int[] nums, int m) {
        TreeMap<Long , Integer> left = new TreeMap<>();
        TreeMap<Long , Integer> right = new TreeMap<>();

        int gap = m - 1 ; 
        left.put((long)nums[0] , 1);
        int i = gap ; 
        int n = nums.length ; 
        for(; i < n ; i++){
            right.put((long)nums[i], right.getOrDefault((long)nums[i] , 0)+1);
        }

        i = 0 ; 
        int j = gap ; 
        long maxi = 0 ; 
        for(; j < n ; j++ , i++){
            left.put((long)nums[i] , left.getOrDefault((long)nums[i] , 0) + 1);
            
            long max1 = left.lastKey();
            long max2 = right.lastKey();

            long min1 = left.firstKey();
            long min2 = right.firstKey();
            
            long posProd = max1*max2 ;
            long negProd = min1*min2 ;
            maxi = Math.max(maxi ,Math.max(posProd , negProd));

            int freq = right.get((long)nums[j]);
            if(freq == 1){
                right.remove((long)nums[j]);
            }else{
                right.put((long)nums[j] , freq-1);
            }
        }
        return maxi ;
    }
}©leetcode
}
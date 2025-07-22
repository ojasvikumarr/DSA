class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // I will have a running sum 
        // Two pointer appraoch 
        // with a hashMap to track the frequency of the elements 
        Map<Integer , Integer> map = new HashMap<>();
        int i = 0 ; 
        int j = 0 ; 
        int n = nums.length ; 
        int maxi = 0 ; 
        int sum = 0 ;
        while(i < n){
            int ele = nums[i];
                // this means that duplicate , so we will increase j until we discard the duplicate
                while(j < i && map.containsKey(ele)){
                    map.remove(nums[j]);
                    sum -= nums[j];
                    j++ ;
                }
                map.put(ele , 1);
                sum += ele;
            // System.out.print(sum + " ");
            maxi = Math.max(maxi , sum);
            i++ ; 
        }
        return maxi ;
    }
}
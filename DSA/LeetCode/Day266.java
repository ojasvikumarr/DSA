class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length ; 
        Map<Integer , Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            set.add(nums[i]);
        }
        int prev = -1 ;
        int counter =0 ; 
        int maxi = 0 ;
        for(int key : set){
            // System.out.println(prev + " " + key);
            if(counter == 0){
                prev = key ;
                counter++ ; 
            }else if(key - prev == 1){
                maxi = Math.max(maxi ,map.get(prev) + map.get(key));
            }
            prev = key ;
        }
        return maxi; 
    }
}
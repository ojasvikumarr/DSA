class Day274 {
    int[] nums ; 
    Map<Integer, Integer> map ; 
    Map<Integer , Integer> idx ; 
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums = nums1 ;
        map = new HashMap<>();
        idx = new HashMap<>();

        int m = nums2.length ;
        for(int i = 0 ;i < m; i++){
            map.put(nums2[i] , map.getOrDefault(nums2[i] , 0)+1);
            idx.put(i, nums2[i]);
        }
    }
    
    public void add(int index, int value) {
        int val = idx.get(index);
        int freq = map.get(val);
        if(freq > 1){
            map.put(val , freq-1);
        }else{
            map.remove(val);
        }
        int newValue = (value+val) ;
        map.put(newValue , map.getOrDefault(newValue , 0)+1);
        idx.put(index , newValue);
    }
    
    public int count(int tot) {
        int count = 0 ; 
        int n = nums.length ; 
        

        for(int i = 0 ; i < n ; i++){
            int diff = tot - nums[i];
            count += map.getOrDefault(diff , 0);
        }

        return count ;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
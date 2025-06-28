class Day265 {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length ; 
        Map<Integer , Integer> map = new HashMap<>();
        int[] newArr = Arrays.copyOf(nums , n);
        Arrays.sort(newArr);
        for(int i = n-1 ; i >= n-k ; i-- ){
            map.put(newArr[i] , map.getOrDefault(newArr[i] , 0)+1);
        }
        int[] res = new int[k];
        int counter = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int ele = nums[i];
            // System.out.println(ele + " ");
            if(map.containsKey(ele)){
                res[counter] = ele ; 
                int freq = map.get(ele);
                if(freq == 1){
                    map.remove(ele);
                }else{
                    map.put(ele , freq-1);
                }
                counter++ ;
            }
            if(counter == k) break ;
        }
        return res ;
    }
}
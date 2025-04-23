package LeetCode;

public class Day199 {
    class Solution {
        public int countLargestGroup(int n) {
            // Set<Integer> set = new HashSet<>();
            // Map<Integer , Integer> map = new HashMap<>();
            //at max we will have 36 sum 
            //we can use a simple arr 
            int[] arr = new int[40];
            int maxi = 0 ; 
            for(int i = 1 ; i <= n ; i++){
                // StringBuilder sb = new StringBuilder(String.valueOf(i));
                int val = 0 ;
                for(char c : String.valueOf(i).toCharArray()){
                    val += (c-'0');
                }
                arr[val]++ ;
                maxi = Math.max(maxi , arr[val]);
            }
            // System.out.println(set); 
            int res = 0 ; 
            // for(Integer key : map.keySet()){
            //     if(map.get(key) == maxi){
            //         res++ ; 
            //     }
            // }
            for(int ele : arr){
                if(ele == maxi) res++ ; 
            }
            return res ;
        }
    }
}

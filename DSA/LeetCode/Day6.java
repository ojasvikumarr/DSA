import java.util.*;

public class Day6 {
    public int[] findErrorNums(int[] nums) {
        int repeat = -1;
        int missing = -1;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            map.put(i, map.getOrDefault(i, 0));
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 2) {
                repeat = key;
            }
            if (map.get(key) == 0) {
                missing = key;
            }
        }
        int result[] = { repeat, missing };
        return result;
    }
}
// int n = nums.length ;
// int repeat = 0 ;
// int missing = 0 ;
// for(int i = 1 ; i < n+1 ; i++ ){
// if(nums[i-1] != i){
// repeat = nums[i-1];
// missing = i ;
// nums[i-1] = i ;
// }
// }

// int result[] = {repeat , missing};
// return result ;
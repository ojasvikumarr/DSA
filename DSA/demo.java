import java.util.HashMap;

public class demo {
    public static int singleNumber(int nums[]){
        int x = -1 ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(map.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return x ;
    }
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int max = recur(A , 0 , K);
        return max ;
    }
    public static int recur(int arr[] , int idx , int K){
        if(idx == arr.length){
            return 0 ;
        }
        if(K==0){
            return 0 ;
        }
        int pick = Integer.MIN_VALUE ;
        if(K>=arr[K]) pick = recur(arr , idx+1 , K-arr[idx]) + 1;
         
        int notPick = recur(arr , idx+1 , K) ;
        return Math.max(pick , notPick);
    }
}


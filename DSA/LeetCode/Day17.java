import java.util.* ;
import java.util.Arrays;

public class Day17 {
    public static int partition(int[] arr , int low , int high){
        int pivot = arr[low];
        int l = low ;
        int r = high ;
        while(l < r){
            while(arr[l] < pivot && l <= high-1){
                l++ ;
            }
            while(arr[r] > pivot && r >= low+1){
                r-- ;
            }
            if(l < r){
                int temp = arr[l] ;
                arr[l] = arr[r];
                arr[r] = temp ;
            }
        }
                int temp = arr[low] ;
                arr[low] = arr[r];
                arr[r] = temp ;
                return r ;
    }
    public static void QuickSort(int[] arr , int low , int high){
        if(low < high){
            int pIndex = partition(arr , low , high);
            QuickSort(arr, low, pIndex-1);
            QuickSort(arr, pIndex+1, high);
        }
    }


    class Solution {
//this is the pick not pick approach
        public void Combination(int arr[] , int idx , int target , List<List<Integer>> ans , List<Integer> ds){
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }
            if (idx == arr.length || target < 0) {
                return;
            }
                ds.add(arr[idx]);
                Combination(arr , idx+1 , target-arr[idx] , ans , ds);
                ds.remove(ds.size() -1);
            
            Combination(arr , idx+1 , target , ans , ds);
        }
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            Combination(candidates ,0 , target , ans , new ArrayList<>());
            return ans ;
        }
    }


//This is the picking of subsequence approach
    public static void combinationSumIIhelper(int idx , int arr[] , int target , List<List<Integer>> ans , List<Integer> ds){
        if(target == 0){
                ans.add(new ArrayList<>(ds));
                return ;
            }
        if(target < 0 || idx == arr.length){
            return ;//target < 0 indicates that an element greater than the target has been found thus terminate the branch
        }
        ds.add(arr[idx]);
        combinationSumIIhelper(idx+1, arr, target - arr[idx], ans, ds);
        ds.remove(ds.size() - 1);

        while (idx + 1 < arr.length && arr[idx] == arr[idx + 1]) {
            idx++;
        }
        combinationSumIIhelper(idx+1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        combinationSumIIhelper(0, arr, target, ans, new ArrayList<>());
        return ans ;
    }

}


package PlacementTime.DP;
import java.util.* ; 
import java.util.Arrays;

public class TargetSum {
    class Solution {
    static int memo[][] ; 
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        //i have two options on every index 
        //either i pick or i dont pick it 
        //as there can be many solutios to the problem 
        //i will be opting for a resursive solution 
        //exploring all the pahs and return true if theres a path to the sum 
        int n = arr.length ; 
        memo = new int[n][sum+1];
        for(int[] row : memo) Arrays.fill(row , -1);
        // return solve(arr , n-1 , sum);
        return tabulation(arr , sum , n);
    }
    public static boolean tabulation(int[] arr , int sum , int n ){
        boolean[][] tab = new boolean[n][sum+1];
        //bottom up appraoch 
        //from the base case to the required case 
        //what will be the base case?
        // if sum is 0 then we accept it 
        for(int i = 0 ; i < n ; i++){
            tab[i][0] = true ; 
        }
        if(arr[0] <= sum)
        tab[0][arr[0]] = true ; 
        for(int i = 1 ; i < n ; i++){
            for(int target = 1 ; target <= sum ; target++){
                boolean pick = false ; 
                if(target - arr[i] >= 0){
                    pick = tab[i-1][target-arr[i]];
                }
                boolean notpick = tab[i-1][target];
                tab[i][target] = pick || notpick ;
            }
        }
        return tab[n-1][sum];
    }
    public static boolean solve(int[] arr , int idx , int sum){
        if(sum == 0){
            return true ; 
        }else if(idx < 0){
            return false ; 
        }
        if(memo[idx][sum] != -1){
            return memo[idx][sum] == 1 ? true : false ; 
        }
        boolean pick = false ; 
        if(sum - arr[idx] >= 0){
            pick = solve(arr , idx-1 , sum - arr[idx]) ;
        }
        boolean notpick = solve(arr , idx-1 , sum) ;
        boolean result = pick || notpick ; 
        memo[idx][sum] = (result ? 1 : 0);
        return result ; 
    }
    public static boolean targetSum(int arr[] , int sum){
        boolean[] tab = new boolean[sum+1];
        tab[0] = true ; 
        int n = arr.length ; 
        for(int i = 0 ; i < n ; i++){
            for(int target = sum ; target >= arr[i]; target--){
                // if(target - arr[i] >= 0)
                tab[target] |= tab[target-arr[i]];
            }
        }
        return tab[sum];
    }
    public static boolean targetSumNeg(int[] arr , int sum){
        Set<Integer> dp = new HashSet<>();
        dp.add(0);// as sum of 0 is always accepted 
        for(int num : arr){
            Set<Integer> newDp = new HashSet<>(dp);
            for(int ele : dp){
                newDp.add(ele +num);
            }
            dp = newDp ; 
        }
        return dp.contains(sum);

    }
}
}

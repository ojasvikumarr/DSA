package LeetCode ; 
import java.util.Arrays ; 
public class Day161{
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            long sum = 0 ; 
            // PriorityQueue<Integer> main = new PriorityQueue<>((a , b) -> b - a);
            for(Integer candle : candies){
                 sum += candle ; 
                //  main.add(candle);
            }
    
            Arrays.sort(candies) ; 
            int n = candies.length ;
            for(int i =0 ; i < n/2 ; i++){
                int temp = candies[i];
                candies[i] = candies[n-i-1];
                candies[n-i-1] = temp ; 
            }
    
            if(sum < k) return 0 ; 
            int avg = (int)Math.floor((double)sum/k);
            avg = (avg == 0 ? 1 : avg);
            int l = 1 ; 
            int r = avg ; 
            int interRes = 0; 
            while(l <= r){
                int mid = l + ((r-l)/2) ;
                // System.out.println(mid); 
                if(solve(candies , k, mid)){
                    //if its true 
                    interRes = mid ; 
                    l = mid+1  ; 
                }else{
                    r = mid - 1 ; 
                }
                // System.out.println();
            }
            return interRes ;
        }
        public boolean solve(int[] candies , long k , int max){
            for(Integer candy : candies){
                if(candy < max && k != 0){
                    return false ;
                }else{
                    //candy >= max 
                    k -= (candy/max);
                }
                if(k <= 0) return true ;
            }
            return false ;
        }
    
    }
}
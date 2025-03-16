package LeetCode;

public class Day163 {
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            int mini = Integer.MAX_VALUE ;
            int maxi = Integer.MIN_VALUE ; 
            for(Integer it : ranks){
                mini = Math.min(mini , it);
                maxi = Math.max(maxi , it);
            }
            // long l = mini;
            long l = mini;
            long r = (long)maxi*(cars)*(cars);//No type casting caused problem 
            long interRes = 0 ; 
            while(l <= r){
                long mid = l + (r-l)/2 ; 
                if(isPossible(ranks ,cars ,mid)){
                    interRes = mid ;
                    r = mid -1 ; 
                }else{
                    l = mid + 1 ;
                }
            }
            return interRes ;
        }
        public boolean isPossible(int[] ranks , int cars , long mid){
            long carsRepaired = 0 ; 
            for(Integer rank : ranks){
                carsRepaired += (long)Math.sqrt((double)mid/rank);//ignoring time complexity of sqrt 
            }
            return carsRepaired >= cars ; 
        }
    }
}

package SlidingWindow;

public class MeeetingSchedule {
    class Solution {
        public int maxFreeTime(int n, int k, int[] start, int[] end) {
            int m = start.length ; 
            int[] dp = new int[m+1];
            dp[0] = start[0] ;
            for(int i = 1 ; i < m ; i++){
                dp[i] = start[i] - end[i-1];
            }
            dp[m] = n - end[m-1];
    
            //k+1 ki window banegi 
            int maxi = Integer.MIN_VALUE ; 
            int meetings = 0 ; 
            int freeTime = 0 ; 
            int j = 0 ; 
            for(int i = 0 ; i < m+1 ; i++){
                while(meetings < k+1 && j < m+1){
                    freeTime += dp[j];
                    System.out.println(freeTime);
                    meetings++ ; 
                    j++ ;
                }
                maxi = Math.max(maxi , freeTime);
                freeTime -= dp[i] ; 
                meetings-- ;
    
                    System.out.println("---");
            }
            return maxi ; 
        }
    
        public int maxFreeTimeII(int n, int k, int[] start, int[] end) {
            int maxi = Integer.MIN_VALUE ;
            int m = start.length ; 
            int freeTime = 0 ; 
            int meetings = 0 ; 
            int j = 0 ; 
            while(j < m){
                int i = 0 ; 
                while(meetings < k && j < m){
                    if(freeTime == 0)
                    freeTime += start[j] - (j == 0 ? 0 : end[j-1]) ;
    
                    freeTime += (j+1 == m ? n : start[j+1]) - end[j];
                System.out.println(freeTime);
                    
                    meetings++ ;
                    j++ ;
                }
                System.out.println("---");
                maxi = Math.max(maxi , freeTime);
                freeTime -= start[i] - (i == 0 ? 0 :  end[i-1]);
                i++ ;
                meetings--; 
            }
            return maxi ; 
        }
    }
}

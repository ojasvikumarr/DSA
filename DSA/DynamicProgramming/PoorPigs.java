package DynamicProgramming;

public class PoorPigs {
    class Solution {
        public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
            int total = minutesToTest / minutesToDie ;
            // (total+1)^pigs >= buckets ;
            int pigs = 0 ; 
            while(Math.pow(total+1 , pigs) < buckets){
                pigs++ ;
            }
            return pigs ;
        }
    }
}

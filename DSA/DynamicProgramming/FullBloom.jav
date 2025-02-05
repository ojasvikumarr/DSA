package DynamicProgramming;

public class FullBloom{
    class Solution {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int n = plantTime.length ; 
            int[][] pairs = new int[n][2];
    
            for(int i = 0 ; i < n ; i++){
                pairs[i][0] = plantTime[i];
                pairs[i][1] = growTime[i];
            }
            Arrays.sort(pairs , (a , b) -> b[1] - a[1]);
    
            int t = 0 ; 
            int c = 0 ; 
            for(int[] pair : pairs){
                c += pair[0];
                t = Math.max(t , c + pair[1]);
            }
    
            return t ;
        }
        public int earliestFullBloomII(int[] plantTime, int[] growTime) {
            // either we have to 
            // a. sumOfPlant + min(grow)
            // b. sumOfGrow + min(plant)
            // en dono ka decision depend upon min of both
    
            int sumPlant = 0 ; 
            int minPlant = Integer.MAX_VALUE ; 
            int sumGrow = 0 ; 
            int minGrow = Integer.MAX_VALUE ;
            int n = plantTime.length ; 
    
            for(int i = 0 ;i < n ; i++){
                sumPlant += plantTime[i];
                minPlant = Math.min(minPlant , plantTime[i]);
                sumGrow += growTime[i];
                minGrow = Math.min(minGrow , growTime[i]);
            }
            int way1 = sumPlant + minGrow ;
            int way2 = sumGrow + minPlant ; 
            System.out.println((sumPlant + " " + sumGrow));
            System.out.println((way1 + " " + way2));
            // if(sumPlant == sumGrow){
            //     return Math.min(way1 , way2);
            // }
            // if(sumPlant > sumGrow) {
            //     return way1 ;
            // }else{
            //     return way2 ; 
            // }
            return way1;
        }
    }
}
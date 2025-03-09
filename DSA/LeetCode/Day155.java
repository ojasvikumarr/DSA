public class Day155 {
    class Solution {
        public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
            int n = fruits.length ;
            int result = 0 ; 
            for(int i = 0 ; i < n ; i++){
                int num = fruits[i];
                boolean flag = false ;
                for(int j = 0 ; j < n ;j++){
                    if(num <= baskets[j] && baskets[j] != -1){
                        baskets[j] = - 1; 
                        flag = true ; 
                        break ; 
                    }
                }
                if(flag == false){
                    //we didnt et a basket 
                    result++ ; 
                }
            }
            return result ; 
        }
    }
}

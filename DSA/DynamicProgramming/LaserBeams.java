package DynamicProgramming;

public class LaserBeams {
    class Solution {
        public int numberOfBeams(String[] bank) {
            int count = 0 ; 
            int first = 0 ; 
            for(int i = 0 ; i < bank.length ; i++){
                //traverse the string 
                boolean secFlag = false ;
                int sec = 0 ; 
                if(first != 0){
                    secFlag = true ; 
                }
                for(char c : bank[i].toCharArray()){
                    if(c == '1'){
                        if(secFlag == false)
                        first++ ;
                        else if (secFlag == true)
                        sec++ ;
                    }
                }
                
                if(secFlag == true && sec != 0){
                    count += first*sec ;
                    first = sec ; 
                    sec = 0 ; 
                    secFlag = false ;
                }
            }
    
            return count ; 
        }
    }
}

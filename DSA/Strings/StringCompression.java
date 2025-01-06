package Strings;

public class StringCompression {
    class Solution {
        public int compress(char[] chars) {
            int n = chars.length;
            int idx = 0 ; 
            int i = 0 ; 
            while(i < n){
                char currChar = chars[i];
                int count = 0 ; 
                while(i < n && chars[i] == currChar){
                    count++ ;
                    i++ ;
                }
                chars[idx] = currChar ; 
                idx++ ;
                if(count > 1){
                    String str = String.valueOf(count);
                    for(Character c : str.toCharArray()){
                        chars[idx] = c ;
                        idx++ ;
                    }
                }
            }
            return idx ;
        }
        public int compressII(char[] chars) {
            int ans = 0 ; 
            int counter = 1 ; 
    
            char currChar = chars[0];
            // int idx = 1 ; 
    
            for(int i = 0 ; i < chars.length ; i++){
                if(i == 0){
                    ans++ ;
                    continue ;
                }
    
                //Now the game begins 
                if(chars[i] != chars[i-1]){
                    //a new character has been encountered 
                    //check whther theres a frequency of prev character to be added or not 
                    currChar = chars[i-1];
                    chars[ans-1] = currChar ;
                    if(counter != 1){
                        String count = String.valueOf(counter) ;
                        int val = count.length();
                        for(int j = 0 ; j < val ; j++){
                            chars[ans] = count.charAt(j);
                            ans++ ;
                        }
                        // idx += val+1;
                        // chars[idx] = chars[i];
                        counter = 1 ;
                    }
                    //Now adding the new Element in the answer 
                    ans++ ;
                }
                else if(chars[i] == chars[i-1]){
                    counter++ ;
                }
            }
            if(counter != 1){
                        String count = String.valueOf(counter) ;
                        int val = count.length();
                        for(int j = 0 ; j < val ; j++){
                            chars[ans] = count.charAt(j);
                            ans++ ;
                        }
                        counter = 1 ;
                    }else{
                        chars[ans-1] = chars[chars.length-1];
                    }
            return ans ;
        }
    }
}

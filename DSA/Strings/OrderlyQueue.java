package Strings;

public class OrderlyQueue {
    class Solution {
        public String orderlyQueue(String s, int k) {
            int[] freq = new int[26];
            int mini = 0 ;
            for(char c : s.toCharArray()){
                mini = Math.min(mini ,c-'a') ;
                freq[c-'a']++ ;
            }
            StringBuilder ans = new StringBuilder();
            if(k == 1){
                String result = s ;
                for(int l = 1 ; l < s.length() ; l++){
                    String str = s.substring(l) + s.substring(0 , l);
                    // result = Math.min(str , result);
                    result = result.compareTo(str) < 0 ? result : str ;
                }
                return result ;
            }else if(k > 1){
                //We'll sort the string 
                // that will be simple
                for(int i = 0 ; i < 26 ; i++){
                    if(freq[i] != 0){
                        for(int j = 0 ; j < freq[i] ; j++){
                            ans.append((char)(i+'a'));
                        }
                    }
                }
            }
            return ans.toString();
        }
    }
}

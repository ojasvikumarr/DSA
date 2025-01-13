Package LeetCode ; 
public class Day99 {
    class Solution {
        public int minimumLength(String s) {
            int n = s.length();
            int[] freq = new int[26];
            for(int i = 0; i < s.length() ; i++){
                freq[s.charAt(i)-'a']++ ;
            }
            int ans = 0 ; 
            for(int i = 0 ; i < 26 ;i++){
                if(freq[i] < 3) ans += freq[i];
                else if(freq[i] % 2 == 0){
                    ans += 2 ;
                }else{
                    ans += 1 ;
                }
            }
            return ans ;
        }
    }
}

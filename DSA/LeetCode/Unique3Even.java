package LeetCode;
import java.util.* ; 
public class Unique3Even {
    class Solution {
        public int totalNumbers(int[] digits) {
            int[] freq = new int[10];
            for(Integer it : digits){
                freq[it]++ ; 
            }
            //if all are zeros then its a zero 
            if(freq[0] == digits.length) return 0 ; 
            int result = 0 ; 
            Set<String> set = new HashSet<>();
            //iterate over last digit 
            for(int last = 0 ; last <= 8 ; last += 2){
                if(freq[last] == 0) continue ; 
                else freq[last]--;
                for(int f = 1 ; f <= 9 ; f++){
                    if(freq[f] == 0) continue ; 
                    else freq[f]-- ; 
                    int res = 0 ; 
                    for(int mid = 0 ; mid <= 9 ; mid++){
                        if(freq[mid] > 0){
                            res += freq[mid];
                            set.add(f+" "+mid+" "+last);
                        }
                    }
                    freq[f]++ ; 
                    result += res ; 
                }
                freq[last]++ ;   
            }
            return set.size() ; 
        }
    }
}

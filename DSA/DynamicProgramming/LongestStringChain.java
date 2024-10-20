package DynamicProgramming;
import java.util.* ;

public class LongestStringChain {
    static Comparator<String> comp = (s1,s2) -> s1.length() - s2.length();
    public boolean compare(String s1 , String s2){
        if(s1.length() != s2.length() +1){
            return false ;
        }
        int first = 0 ;
        int second = 0 ; 
        for(int i = 0 ; i < s1.length() ; i++){
                if(s1.charAt(first) == s2.charAt(second)){
                    first++ ;
                    second++ ;
                }else{
                    first++ ;
                }
        }
        if(first == s1.length() && second == s2.length()){
            return true ;
        }
        return false ;
    }
    public int LongestChain(List<String> arr){
        arr.sort(comp);
        int[] dp = new int[arr.size()];
        Arrays.fill(dp , 1);
        int maxi = 1 ;
        for(int i = 0; i < arr.size() ; i++){
            for(int prevIndex = 0 ; prevIndex < i ; prevIndex++){
                if(compare(arr.get(i) , arr.get(prevIndex)) && 1 + dp[prevIndex] > dp[i]){
                    dp[i] = 1 + dp[prevIndex];
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
            }
        }
        return maxi ;
    }
}

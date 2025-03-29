import java.lang.StringBuilder ; 
import java.util.* ; 
import java.io.* ; 
import java.util.Arrays ; 
public class cp60 {

        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(maxActiveSectionsAfterTrade(s));
            sc.close();
        }
        public static int maxActiveSectionsAfterTrade(String s) {
            int start = 0 ; 
            int end = 0 ; 
            int i = 0 ; 
            int n= s.length();
            int maxi = Integer.MIN_VALUE ; 
            while(i < n){
                char c = s.charAt(i);
                if(c == '0'){
                    while(i < n && s.charAt(i) == '0'){
                        i++ ; 
                        start++ ; 
                    }
                    while(i < n && s.charAt(i) == '1'){
                        i++ ; 
                        // end++ ; 
                    }
                    while(i < n && s.charAt(i) == '0'){
                        i++ ; 
                        end++ ; 
                    }
                    maxi = Math.max(start+end , maxi);
                    start = end;
                    end = 0 ; 
                }else{
                    //its a 1 
                    //either start is not 0 then we can check for duo of 0s
                    if(start != 0){
                        while(i < n && s.charAt(i) == '1'){
                            i++ ; 
                            // end++ ; 
                        }
                        while(i < n && s.charAt(i) == '0'){
                            i++ ; 
                            end++ ; 
                        }
                        maxi = Math.max(start+end , maxi);
                        start = end ; 
                        end = 0 ; 
                    }else{
                        while(i < n && s.charAt(i) == '1'){
                            i++ ; 
                        }
                    }
                }
            }
            return maxi ; 
        }
    }

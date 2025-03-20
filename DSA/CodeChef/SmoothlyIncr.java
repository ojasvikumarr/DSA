package CodeChef;
import java.util.*;

import java.lang.StringBuilder;


public class SmoothlyIncr {
    class Codechef
    {
        public static void main (String[] args) throws java.lang.Exception
        {
            // your code goes here
            Scanner sc = new Scanner(System.in);
                int t = sc.nextInt();
                while(t-- > 0){
                    int n = sc.nextInt();
                    List<Integer> a = new ArrayList<>();
                    for(int i = 0 ; i < n ; i++){
                        a.add(sc.nextInt());
                    }
                    StringBuilder ans = new StringBuilder();
                    if(n < 40){
                        for(int i = 0 ; i < n ; i++){
                            List<Integer> b = new ArrayList<>(a);
                            b.remove(i);
                            ans.append(check(b));
                        }
                    }else{
                        ans.append("0".repeat(n));
                    }
                    System.out.println(ans);
                }
            sc.close();
        }
        public static String check(List<Integer> a){
            if(a.size() == 1) return "1";
    
            List<Integer> diff = new ArrayList<>();
            for(int i = 0 ; i < a.size()-1 ; i++){
                int dif = a.get(i+1) - a.get(i);
                if(dif <= 0) return "0";
                diff.add(dif);
            }
    
            return check(diff);
    
        }
        public static String solveII(List<Integer> a){
            while(a.size() > 1){
                List<Integer> diff = new ArrayList<>(); 
                for(int i = 1 ; i < a.size() ; i++){
                    diff.add(a.get(i) - a.get(i-1));
                }
                for(int i = 1 ; i < diff.size() ; i++){
                    if(diff.get(i-1) >= diff.get(i)){
                        return "0";
                    }
                }
                a = diff ; 
            }
            return "1";
        }
        
    }
    
}

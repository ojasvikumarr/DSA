package CodeForces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class perfectlyBalancedString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            Set<Character> set = new HashSet<>() ;
            for(char c : s.toCharArray()){
                set.add(c);
            }
            int sz = set.size();
            Map<Character , Integer> map = new HashMap<>();
            boolean flag = true ;
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i) ;
                if(map.containsKey(c)){
                    if( (i - map.get(c)) != sz){
                        flag = false ;
                        break ; 
                    }
                    map.put(c , i);
                }else{
                    map.put(c , i);
                }
            }
            if(flag){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }   
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

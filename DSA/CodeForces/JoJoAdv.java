package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoJoAdv {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            sb.append(solve(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static long solve(String s){
        //we need to get the largest window 
        long maxi = 0 ; 
        int i = 0 ; 
        int counter = 0 ; 
        boolean zeros = false ;
        for(char c : s.toCharArray()){
            if(c == '0') zeros = true ; 
        } 
        if(zeros == false){
            //no zeros 
            return (long)s.length()*(long)s.length() ;
        }else{
            //i duplicate the string three times to find the longest sequence of 1s
            StringBuilder cyclic = new StringBuilder();
            cyclic.append(s).append(s).append(s);
            // System.out.println(cyclic);
            while(i < cyclic.length()){
                if(i < cyclic.length() && cyclic.charAt(i) == '1'){
                    counter = 0 ; 
                    while(i < cyclic.length() && cyclic.charAt(i) == '1'){
                        i++ ; 
                        counter++ ; 
                    }
                    maxi = Math.max(maxi , counter);
                }else{
                    i++ ; 
                }
            }
        }
        // System.out.println(maxi);
        long res = 0 ; 
        if(maxi == 1){
            return 1 ;
        }else if(maxi % 2 != 0){
            //even 
            maxi++ ; 
            res = (maxi/2)*(maxi/2);
            // System.out.println(res);
        }else{
            res = ((maxi/2) + 1)*(maxi/2);
        }
        // System.out.println(res);
        return res ;
    }
}

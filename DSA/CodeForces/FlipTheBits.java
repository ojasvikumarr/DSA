package CodeForces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlipTheBits {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            String b = br.readLine();
            int[] o = new int[n];
            int[] I = new int[n];
            if(a.charAt(0) == '0'){
                o[0] = 1 ;
            }else{
                I[0] = 1 ;
            }
            for(int i = 1; i < n ; i++){
                if(a.charAt(i) == '0'){
                    o[i] += o[i-1] + 1 ;
                    I[i] = I[i-1];
                }else{
                    I[i] += I[i-1] + 1 ;
                    o[i] = o[i-1];
                }
            }

            boolean flag = true ; 
            int flips = 0 ; 
            for(int i = n-1 ; i >= 0 ; i--){
                if(a.charAt(i) != b.charAt(i)){
                    //if flips are odd numbered then 
                    //no problem 
                    if(flips%2 == 0){
                        //if even flips we check for the pairs 
                        if(o[i] != I[i]){
                            flag = false ;
                            break ; 
                        }
                        flips++ ;
                    }
                }else{
                    //bits are same
                    //we check flips are even or no 
                    if(flips%2 != 0){
                        //they are odd that means i need to flip 
                        if(o[i] != I[i]){
                            flag = false ;
                            break ; 
                        }
                        flips++ ; 
                    }
                }
                // System.out.println(i + " " + o[i] + " " + I[i] + " " + flips); 
            }
            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb); 
    }
}

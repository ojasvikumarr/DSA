import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            
            int one = 0 ; 
            int zero = 0 ; 
            int[] arr = new int[n];

            for(int i = 0 ; i < n ; i++){
                char c = s.charAt(i);
                if(c == '1' && zero != 0){
                    one++  ;
                    arr[i] = Math.min(one , zero);
                }else if(c == '0' && one != 0){
                    zero++ ;
                    arr[i] =( (i-1 >= 0) ? arr[i-1] : 0 ); 
                }else if(c == '1'){
                    one++ ; 
                }
            }
            sb.append(arr[n-1]).append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }        
        
}
   
// int ones = 0 ;
//             int l = 0 ; 
//             int r = 0 ; 
//             int mini = Integer.MAX_VALUE ;
//             if(one == 0){
//                 sb.append(0).append("\n");
//                 continue ; 
//             }
//             while( r < n ){
//                 while(r-l < one && r < n){
//                     if(s.charAt(r) == '1'){
//                          ones++ ;
//                         //  System.out.println("yes");
//                     }
//                     r++ ; 
//                 }
//                 //now one is zero 
//                 mini = Math.min(one-ones , mini);
//                 if(s.charAt(l) == '1') ones-- ;
//                 l++ ; 
//             }
//             sb.append(mini).append("\n");
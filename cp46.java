import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp46 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String pat = sc.next();
            String txt = sc.next();
            boolean flag = true ;
            StringBuilder sb = new StringBuilder(pat);
            // for(int i = 0 ; i <= 26 ; i++){
            //     // if(pat.indexOf(txt) != -1){
            //     if(sb.indexOf(txt) != -1){
            //         System.out.println(i);
            //         flag = false ; 
            //         break ; 
            //     }   
            //     sb.append(sb);
            //     // pat = pat + pat ; 
            // }

            int count = 0;
            while(sb.length() < txt.length()){
                sb.append(sb);
                count++ ; 
            }
            if(sb.indexOf(txt) != -1){
                System.out.println(count);
                continue ; 
            }
            //lets give one more chance 
            sb.append(sb);
            count++ ; 
            if(sb.indexOf(txt) != -1){
                System.out.println(count);
            }else{
                System.out.println(-1);
            }   
            // if(flag) System.out.println(-1);
        }
        sc.close();
    }    
}

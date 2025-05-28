import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ; 
public class cp87 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int val = 0 ; 
            int mul = 1 ; 
            while(mul <= n){
                boolean flag = true ; 
                for(int i = 1 ; i <= 9 ; i++){
                    if(i*mul <= n){
                        val++ ;
                    }else{
                        flag = false ;
                        break ; 
                    }
                }
                if(!flag) break ; 
                mul *= 10 ; 
            }
            sb.append(val);
            sb.append("\n");

        }
        System.out.println(sb.toString());
   }
   public static int gcd(int a , int b){
       if(b == 0) return a ; 
       return gcd(b , a%b);
   }
}



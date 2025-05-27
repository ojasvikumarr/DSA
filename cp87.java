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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            boolean flag = false ;
            for(int i = 0 ; i < n ; i++){
                for(int j = i+1 ; j < n ; j++){
                    if(gcd(arr[i] , arr[j]) <= 2){
                        flag = true ;
                        break ; 
                    }
                }
            }
            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
   public static int gcd(int a , int b){
       if(b == 0) return a ; 
       return gcd(b , a%b);
   }
}



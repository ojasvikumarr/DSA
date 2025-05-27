import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

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
            int xor = 0 ;
            boolean zero = false ; 
            for(int i = 0 ;i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                xor ^= arr[i];
                if(arr[i] == 0) zero = true ; 
            }

            // if((zero && n % 2 == 0 )||(!zero && n%2 != 0)){
            if(n%2 != 0){
                //this means its odd 
                sb.append(xor);
            }else{
                //its really even
                if(xor == 0){
                    sb.append(0);
                }else{
                    sb.append(-1);
                }
            }
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



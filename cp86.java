import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp86 {
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
            int mini = Integer.MAX_VALUE ; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                mini = Math.min(mini , arr[i]);
            }
            int f = 0 ; 
            for(int i = 0 ;i < n; i++){
                if(arr[i] == mini) f++ ; 
            }
            if(f == n){
                sb.append(-1).append("\n");
            }else{
                sb.append(f + " " + (n-f)).append("\n");
                for(int i = 0 ; i < f ; i++){
                    sb.append(mini + " ");
                }
                sb.append("\n");
                for(int i = 0 ; i < n ; i++ ){
                    if(arr[i] != mini){
                        sb.append(arr[i] + " ");
                    }
                }
                sb.append("\n");
                
            }
        }
        System.out.println(sb.toString());
   }
}



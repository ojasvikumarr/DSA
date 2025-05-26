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
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int diff = Integer.MAX_VALUE ; 
            for(int i = 1; i < n ; i++){
                diff = Math.min(diff , arr[i] - arr[i-1]);
            }
            if(diff < 0){
                sb.append(0);
            }else{
                sb.append((diff/2) + 1);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



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
            for(int i = 0 ;i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 1; 
            int prev = arr[0];
            for(int i = 1 ; i < n ; i++){
                if(prev + 1 < arr[i]){
                    count++ ; 
                    prev = arr[i] ;
                }
            }
            sb.append(count);
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



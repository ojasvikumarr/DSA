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
            int neg = 0 ; 
            int pos = 0 ; 
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] < 0){
                    neg++ ; 
                }else{
                    pos++ ; 
                }
            }

            if(pos >= neg){
                if(neg % 2 == 0){
                    sb.append(0);
                }else{
                    sb.append(1); 
                }
            }else{
                int rem = neg - pos ; 
                int val = (int)Math.ceil((double)rem/2) ; 
                neg -= val ; 
                if(neg % 2 != 0) val++ ; 
                sb.append(val);
            }
           
            
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



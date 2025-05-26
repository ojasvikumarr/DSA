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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
           
            if(x%k != 0){
                sb.append(1 + " \n");
                sb.append(x);
            }else{
                sb.append(2 + " \n");
                sb.append((x-1) + " " + 1 + " ");
            }
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(c % 2 == 0){
                if(a <= b){
                    sb.append("Second");
                }else{
                    sb.append("First");
                }
            }else{
                if((a+1) <= b){
                    sb.append("Second");
                }else{
                    sb.append("First");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



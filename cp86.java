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
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());


            if(x != 1){
                sb.append("YES\n");
                sb.append(n + "\n");
                for(int i = 0 ; i < n ;i++){
                    sb.append(1 +" ");
                }
            }else{
                if(k == 2){
                    if(n % 2 == 0){
                        //then its good 
                        sb.append("YES\n");
                        sb.append(n/2 + "\n");
                        for(int i = 0 ;i < n/2 ; i++){
                            sb.append(2 + " ");
                        }
                    }else{
                        sb.append("NO");
                    }
                }else if(k > 2){
                    if(n%2 == 0){
                        sb.append("YES\n");
                        sb.append(n/2 + "\n");
                        for(int i = 0 ;i < n/2 ; i++){
                            sb.append(2 + " ");
                        }
                    }else{
                        sb.append("YES\n");
                        sb.append((n/2) + "\n");
                        for(int i = 0 ;i < n/2-1 ; i++){
                            sb.append(2 + " ");
                        }
                        sb.append(3 + " ");
                    }
                }else{
                    sb.append("NO");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



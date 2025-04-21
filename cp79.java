import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp79 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int res = 0 ; 
            for(int i = 1 ; i < n ; i++){
                if(s.charAt(i) != s.charAt(i-1)){
                    res++ ;
                }
            }
            if(res == 0){
                //thats is all are 0s or 1s 
                if(s.charAt(0) == '1'){
                    sb.append((n+1));
                }else{
                    sb.append((n));
                }
                sb.append("\n");
                continue ; 
            }

            if(s.charAt(0) == '1') res++ ; 
            if(res > 2){
                sb.append((n+res-2));
            }else if(res > 1){
                sb.append((n+res-1));
            }else{
                sb.append((n+res));
            }
            sb.append("\n");
        }
        System.out.println(sb); 
    }
}

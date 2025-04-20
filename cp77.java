import java.io.InputStreamReader;
import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ;
public class cp77 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            long left = 0 ;
            int cnt = 0 ; 
            for(int i = 0 ; i < n ; i++){
                if(s.charAt(i) == 'B'){
                    int jumps = (i-cnt) ;
                    left += (jumps+1)/2 ;
                    cnt++ ; 
                }
            }
            long right = 0 ;
            cnt = 0 ; 
            for(int i = n-1 ; i >= 0 ; i--){
                if(s.charAt(i) == 'P'){
                    int jumps = (n-i-cnt-1) ;
                    right += (jumps+1)/2 ;
                    System.out.println(right);
                    cnt++ ; 
                }
            }
            System.out.println(left + " --  " + right);
            sb.append(Math.min(left , right));
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

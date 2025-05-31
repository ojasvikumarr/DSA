import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp92 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());

            if(x%2 == 0){
                if(n%4 == 0){
                    sb.append(x);
                }else if(n%2 == 0){
                    sb.append(x+1);
                }else if((n-1)%4 == 0){
                    sb.append(x-n);
                }else{
                    sb.append(x+n+1);
                }
            }else{
                if(n%4 == 0){
                    sb.append(x);
                }else if(n%2 == 0){
                    sb.append(x-1);
                }else if((n-1)%4 == 0){
                    sb.append(x+n);
                }else{
                    // System.out.println("Y");
                    sb.append(x-n-1);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

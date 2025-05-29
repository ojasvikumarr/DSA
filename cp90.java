import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder; 
public class cp90 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int zeros = 0 ; 
            for(int i = 0 ;i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] == 0) zeros++ ; 
            }
            
            int tag = 0 ; 
            int i = 0 ; 
            while(i < n){
                while(i < n && arr[i] == 0){
                    i++ ; 
                }
                if(i == n) break ; 
                tag++ ;
                while(i < n && arr[i] != 0){
                    i++ ; 
                }
            }

            if(zeros == n){
                sb.append(0);
            }else if(tag == 1){
                    sb.append(1); 
            }else {
                sb.append(2);
            }
           sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int gcd(int a , int b){
        if(b == 0){
            return a ; 
        }
        return gcd(b , a%b);
    }
}

import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            int xor = 0 ; 
            // for(int i = 0 ; i < a ; i++){
            //     xor ^= i ; 
            // }
            // int rem = (a-1)%4 ; 
            // if(rem == 0){
            //     xor = a ;
            // }else if(rem == 1){
            //     xor = 1 ; 
            // }else if(rem == 2){
            //     xor = a + 1 ;
            // }else{
            //     xor = 0 ;
            // }
            if(a% 4 == 1){
                xor = a-1 ; 
            }else if(a % 4 == 2){
                xor = 1 ;
            }else if(a % 4 == 3){
                xor = a ;
            }else{
                xor = 0 ; 
            }
            // if(xor == b && xor != a){
            //     sb.append(a);
            // }else if(b <= a && b != 0){
            //     sb.append(( a+2));
            // }else{
            //     sb.append((a+1));
            // }
            // System.out.println(xor);
            if(xor == b){
                sb.append(+ a);
            }else if((xor^b) != a || xor == b){
                sb.append((a+1));
            }else{
                sb.append((a+2));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

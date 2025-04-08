import java.util.StringTokenizer;
import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp71 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0 ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            

            int count = 0 ; 
            int val = 0 ; 
            boolean flag = false ; 
            if( a < b ){
                //we need to shift it left 
                //and count the number of hsifts 
                //then divide it to 3 2 1 
                while(a < b){
                    a = a<<1 ; 
                    count++ ; 
                }
            }else{
                while(a > b){
                    if((a&1) != 0){
                        sb.append("-1 \n");
                        flag = true ; 
                        break ; 
                    }
                    a = a>>1 ; 
                    count++ ;
                }
            }
            if(flag){
                continue ; 
            }
            if(a != b){
                sb.append(-1 + " \n");
            }else{
                val = (int)Math.floor((double)count/3);
                count = count%3 ; 
                val += (int)Math.floor((double)count/2);
                count = count%2 ; 
                val += count ;
                sb.append(val + " \n");
            }
        }
        System.out.println(sb.toString());
    }
}

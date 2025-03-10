import java.util.* ; 
import java.lang.StringBuilder;
public class cp40 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String x = sc.next();
            String s = sc.next();
            StringBuilder sb = new StringBuilder(x);
            int count = 0 ; 
            int result = -1 ; 
            while(sb.length() <= 30){
                sb.append(sb);
                count++; 
                if(sb.indexOf(s) != -1){
                    result = count ; 
                    break ; 
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

}

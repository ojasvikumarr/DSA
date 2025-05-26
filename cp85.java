import java.util.Scanner;
import java.lang.StringBuilder;

public class cp85 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
            int maxi = Integer.MIN_VALUE ; 
            int mini = Integer.MAX_VALUE;
            int n = sc.nextInt();
            for(int i = 0 ; i < n ; i ++){
                int a = sc.nextInt();
                if(a >= 0){
                    mini = Math.min(mini , a);
                }else{
                    maxi = Math.max(maxi , a);
                }
            }
            if(maxi == Integer.MIN_VALUE){
                sb.append(mini);
            }else{
                sb.append(Math.min(-maxi , mini));
            }
            sb.append("\n");
        System.out.println(sb.toString());
        sc.close();
    }
}

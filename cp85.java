import java.util.Scanner;
import java.lang.StringBuilder;

public class cp85 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long res = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                res += sc.nextInt();
            }
            sb.append(-res + "\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

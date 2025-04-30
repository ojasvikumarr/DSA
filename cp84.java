import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp84 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            boolean flag = false ; 
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
                if(arr[i] == x){
                    flag = true ; 
                }
            }
            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sc.close() ;

    }
}

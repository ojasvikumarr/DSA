import java.util.* ; 
import java.lang.StringBuilder ; 
public class cp61 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder res = new StringBuilder();

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String sa = sc.next();
            String sb = sc.next();
             
            if(solve(sa, sb, n)){
                res.append("YES");
            }else{
                res.append("NO");
            }
            res.append("\n");
        }
        System.out.println(res.toString());
        sc.close();
    }
    public static boolean solve(String a , String b , int n ){
        int odd = 0 ; 
        int even = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(a.charAt(i) == '1'){
                if(i%2 != 0){
                    if(odd <= 0){
                        return false ; 
                    }else{
                        odd-- ; 
                    }
                }else{
                    if(even <= 0){
                        return false ; 
                    }else{
                        even-- ; 
                    }
                }
            }
            if(i%2 == 0 && b.charAt(i) == '0'){
                odd++ ; 
            }else if(i%2 != 0 && b.charAt(i) == '0'){
                even++ ; 
            }
        }
        return true ; 
    }
}

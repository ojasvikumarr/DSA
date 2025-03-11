import java.util.* ; 
 
public class cp45 {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while(t-- > 0){
            long x = (long)sc.nextInt();
            solveII(x);
        }
        sc.close();
    }
    public static void solve(long x){
        for(long y = x-1 ; y >= 1 ; y--){
            long z = x^y; 
            if(x+y > z && x+z > y && y+z > x){
                System.out.println(y);
                return ; 
            }
        }
        System.out.println(-1);
        return ; 
    }
    public static void solveII(long x){
        long l = 1 ; 
        long r = x-1 ; 
        while(l <= r){
            long y = r - (r-l)/2 ;
            long z = x^y; 
            if(x+y > z && x+z > y && y+z > x){
                if(y == r){
                    System.out.println(y);
                    return ; 
                }
                l = y ; 
            }else{
                r = y-1 ; 
            }
        }
        System.out.println(-1);
        return ; 
    }
}

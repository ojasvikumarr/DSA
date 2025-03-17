import java.util.* ; 
public class cp50 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            long k = sc.nextLong();
            long res = 0 ;
            if(n%2 == 0){
                //its is even 
                if(k%2 == 0){
                    //both are even 
                    res += n/k ; 
                    if(n%k != 0){
                        res += 1 ; 
                    }
                }else{
                    //k is odd 
                    k-- ; 
                    res += n/k ; 
                    if(n%k != 0){
                        res += 1 ;
                    }
                }
            }else{
                //n is odd 
                //we need k to be odd 
                if(k%2 == 0){
                    k-- ; 
                    res += n/k ; 
                    if(n%k != 0){
                        res += 1 ;
                    }
                }else{
                    n -= k ; 
                    res++ ; 
                    //now n becomes even 
                    k-- ;
                    res += n/k ;
                    if(n%k != 0){
                        res += 1 ; 
                    }
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}

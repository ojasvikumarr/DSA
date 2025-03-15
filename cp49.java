
    import java.util.*  ;

public class cp49 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            long x = sc.nextLong();
            long sum = (long)n*(n+1)/2 ; 
            if(sum < x){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
        sc.close();
    }
    
}



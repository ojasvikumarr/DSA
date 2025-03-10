import java.util.* ; 

public class cp40 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            double x = sc.nextDouble();   
            int sum = 0 ; 
            for(int i = 0 ; i < n ; i++) {
                sum += sc.nextInt();
            }
            if((double)sum / n == x){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }

}

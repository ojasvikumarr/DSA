import java.util.* ; 
public class cp72 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long x = sc.nextInt();
            long y = sc.nextInt();
            long k = sc.nextInt();

            long ans =((y*k+k-1 + x - 2)/(x-1)) + k;
            System.out.println(ans);
        }
        sc.close();
    }
}

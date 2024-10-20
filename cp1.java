import java.util.* ;

public class cp1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0 ; tc < t ; tc++){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int L = sc.nextInt();
            int R = sc.nextInt();
            if(r <= L) System.out.println(1);
            else if(r < R && L < l){
                System.out.println(r-L+2);
            }
            else if(r > R && L < l){
                System.out.println(R-l+2);
            }
        }
        sc.close();
    }
    public static void helper(){
    }
}

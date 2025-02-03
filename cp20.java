import java.util.*  ;

public class cp20 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int[] arr = new int[5+1];
            for(int i = 1 ; i <= 5 ; i++){
                if(i == 3) {
                    arr[3] = -1 ; 
                    continue ;
                }
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
        sc.close();
    }    
    public static int solve(int[] a){
        boolean flagA = (2*a[2] == a[4] - a[1]);
        boolean flagB = (2*a[4] == a[5] + a[2]);
        boolean flagC = (a[5] - a[4] == a[2] + a[1]);

        if(flagA && flagB && flagC){
            return 3; 
        }else if(flagA || flagB || flagC){
            return 2 ; 
        }
        return 1 ;
    }
}

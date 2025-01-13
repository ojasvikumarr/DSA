import java.util.* ;

public class cp16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int i =0 ; i < n ; i++) a[i] = sc.nextInt();
            for(int i =0 ; i < n ; i++) b[i] = sc.nextInt();
            solve(a , b);

        }
        sc.close();
    }
    public static void solveII(int[] avail , int[] need){
        int count = 0 ;
        for(int i = 0; i < avail.length ; i++){
            if(avail[i] < need[i]){
                count++ ;
            }
        }
        if(count > 1){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
        return ;
    }
    public static void solve(int[] available , int[] needed ){
        int n = needed.length;
        if(n == 1){
            if(available[0] < needed[0]){
                System.out.println("NO");
                return ;
            }
            System.out.println("YES");
            return ;
        }
        int i = 0 ; 
        while(i < n){

            if(available[i] < needed[i]){
                if(decrement(available , i)){
                    System.out.println("NO");
                    return ;
                }
                available[i]++ ;
                i = 0 ;
            }
            i++ ;
        }
        System.out.println("YES");
        return ;
    }
    public static boolean decrement(int[] arr , int i){
        for(int j = 0 ; j <arr.length ; j++){
            if(j == i) continue ;
            if(arr[j] == 0) return true ;
            arr[j]-- ;
        }
        return false ;
    }
}

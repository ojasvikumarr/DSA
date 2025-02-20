import java.util.* ; 

public class cp30 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n-2];
            for(int i = 0 ; i < n-2 ; i++) arr[i] = sc.nextInt();
            if(solve(arr)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static boolean solve(int[] arr){
        int n = arr.length ;
        if(n == 1) return true ;
        for(int i = 1 ; i < n-1 ; i++){
            if(arr[i] == 0 && arr[i-1] == 1 && arr[i+1] == 1) return false ;
        }
        return true ;
    }
}

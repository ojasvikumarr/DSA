import java.util.* ; 
public class cp19 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            System.out.println(solve(arr , n , k));
        }
        sc.close();
    }
    public static int solve(int[] arr , int n , int k){
        if(k == n){
            //check 
            int count = 1 ; 
            for(int i = 1 ; i < n ; i += 2){
                if(arr[i] != count) return count ; 
                count++ ;
            }
            return count ; 
        }
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != 1 && i > 0 && n-i+1 >= k){
                return 1;
            }
        }
        return 2 ; 
    }
    
}

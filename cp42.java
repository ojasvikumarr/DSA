import java.util.* ; 

public class cp42 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt(); 
            solve(n , k);
        }
        sc.close();
    }
    public static void solve(int n , int k){
        if(n == 2){
            System.out.println("2 1");
            return ; 
        }
        int[] arr = new int[n];
        if(k % 2 == 0){
            for(int i = 0 ; i < n ; i++){
                arr[i] = n-1 ; 
            }
            arr[n-2] = n ; 
        }else{
            for(int i = 0 ; i < n ; i++){
                arr[i] = n ; 
            }
            arr[n-1] = n-1 ; 
        }

        for(Integer it : arr){
            System.out.print(it + " ");
        }
        System.out.println();
        return ;
    }
}

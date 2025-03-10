import java.util.* ; 

public class cp34 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            arr[n] = x ; 
            int maxi = Integer.MIN_VALUE ; 
            for(int i = 0 ; i < n+1 ; i++){
                int diff = arr[i] - ( i==0 ? 0 :  arr[i-1]);
                if(i == n){
                    diff *= 2 ; 
                }
                maxi = Math.max(maxi , diff);
            }
            System.out.println(maxi);
        }
        sc.close();
    }

}

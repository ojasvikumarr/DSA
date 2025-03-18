import java.util.Arrays ; 
import java.util.* ; 
public class cp53 {
    static int[] prefixSum ; 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            // prefixSum = new int[m];
            int[] colors = new int[m];
            // int sum = 0 ;
            for(int i = 0 ; i < m ; i++){
                colors[i] = sc.nextInt();
                // sum += colors[i];
                // prefixSum[i] = sum;
            }
            Arrays.sort(colors);    
            solve(colors , n , m);
        }
        sc.close();
    }
    public static void solve(int[] colors , int n , int m){
        long sum = 0 ; 
        long ans = 0 ; 
        int ptr = m-1 ; 
        for(int i = 0 ; i < m ; i++){
            while(ptr >= 0 && colors[i] + colors[ptr] >= n){
                sum += colors[ptr];
                ptr-- ; 
            }
            ans += sum + (m-ptr-1)*(colors[i]-n+1);
        } 
        for(int i = 0 ; i < m ; i++){
            if(colors[i]*2 >= n){
                ans -= 2*colors[i] - n + 1 ;
            }
        }  
        System.out.println(ans);
    }
    // public int solve(int[] colors , int idx , int color , int n , int cIdx){
    //     //i want to have two options either i continue with the color or i change the color
    //     if(idx == n){
    //         return 1 ; 
    //     }
    //     int same = 0 ; 
    //     if(colors[color] >= 0){
    //         same = solve(colors , idx+1 , color-1 , n ,cIdx);
    //     }
    //     int change = 0 ; 
    //     if(prefixSum[cIdx+1] >= n-idx-1){
    //         change = solve(colors , idx+1 , colors[cIdx+1] , n , cIdx+1);
    //     }
    //     return same + change ;
    // }
}
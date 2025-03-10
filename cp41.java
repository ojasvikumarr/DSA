import java.util.* ; 

public class cp41 {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[2*n];
            long sum = 0 ;
            Set<Integer> set = new HashSet<>();
            for(int i = 0 ; i < 2*n ; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
                set.add(arr[i]);
            }
            Set<Long> values = new HashSet<>();
            tabulate(arr, n, sum, values);

            // solve(arr , 0 , n , 0 , sum , values);
            long first = 0 ; 
            for(Long it : values){
                if(!set.contains(it)){
                    first = it ;
                    break ; 
                }
            }
            System.out.print(first+" ");
            for(Integer it : arr){
                System.out.print(it+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    public static void tabulate(int[] arr , int n , long sum , Set<Long> values){
        int len = arr.length; 
        boolean[][][] dp = new boolean[len+1][n+1][(int)sum+1];
        dp[0][0][0] = true ; 


        for(int i = 0 ; i < len ; i++)
            for(int count = 0 ; count <= n ; count++)
                for(int target = 0 ; target <= sum ; target++)
                    if(dp[i][count][target] == true){
                        dp[i+1][count][target] = true ; 
                        if(count < n && target + arr[i] <= sum){
                            dp[i+1][count+1][target + arr[i]] = true ; 
                        }
                    }
                
            
        

        for(int target = 0 ; target <= sum ; target++){
            if(dp[len][n][target]){
                long val = 2*target - sum ; 
                values.add(Math.abs(val));
            }
        }
        return ; 
    }
    public static void solve(int[] arr , int idx , long n , long target , long sum , Set<Long> set){
        if(n == 0){
            long val = 2*target - sum ;
            set.add(Math.abs(val));
            return ; 
        }
        if(idx == arr.length){
            return ; 
        }
        //pick 
        target = target + arr[idx];
        solve(arr , idx+1 , n-1 , target , sum , set);
        //notpick
        target = target - arr[idx];
        solve(arr , idx+1 , n , target , sum , set);

    }

}

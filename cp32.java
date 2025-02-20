import java.util.* ; 

public class cp32 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            // solve(arr , n);    
            int result = 0 ; 
            for(int i = 0 ;i < n ; i++){
                if(arr[i] == 1){
                    result += solve(arr , i , 0);
                }
            } 
            System.out.println(result) ;        
        }
        sc.close();
    }
    public static int solve(int[] arr , int idx , int count){
        if(idx == arr.length){
            return Integer.MIN_VALUE; 
        }
        if(arr[idx] == 3){
            //we need to return 0 
            return 0; 
        }

        int pick = 0 ; 
        if(arr[idx] == 2 || arr[idx] == 3){
            if(arr[idx] == 2) count++ ; 
            pick = count + solve(arr , idx+1 , count);
        }
        int notpick = 0 + solve(arr , idx , count);
        return pick + notpick ; 
    }

}

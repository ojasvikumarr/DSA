import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0 ; i < n ; i++) arr[i] = sc.nextInt();
            solve(arr , n , p);
		}
		sc.close();
	}
    public static void solveII(int[] arr , int n , int p ){
        int[] res = new int[n];
        Arrays.fill(res , Integer.MAX_VALUE);

        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                //left 
                if(i-1 >= 0){
                    int l = i ; 
                    // res[i-1] = (int)Math.ceil((double)(arr[i-1]/p)) ; 
                    while(l >=0){
                        if(arr[l] > arr[l+1]){
                            res[l] = (int)Math.ceil((double)(arr[l]/p)) ; 
                        }
                        l-- ;
                    }
                }
                //right 
                if(i+1 < n){
                    int r = i+1 ;
                    while(r < n){
                        if(arr[r] < arr[r+1]){
                            res[r] = (int)Math.ceil((double)(arr[r]/p)) ; 
                        }
                        r-- ;
                    }
                    res[i+1] = (int)Math.ceil((double)(arr[i+1]/p)) ; 
                }
            }
        }
        //Now the remaining 
        for(int i = 0 ; i < n ; i++){
            if(res[i] == Integer.MAX_VALUE){
                //check min in the left and right 
                //left 
                int l = i-1 ; 
                while(l >= 0){
                    if(res[l] < Integer.MAX_VALUE){
                        res[i] = res[l];
                        break ;
                    }
                    l++; 
                }
                int r = i+1 ; 
                while(r < n){
                    if(res[r] < Integer.MAX_VALUE){
                        res[i] = Math.min(res[i] , res[r]);
                        break ;
                    }
                    r++ ;
                }
            }
        }
    }
    public static void solve(int[] arr , int n , int p){
        int[] res = new int[n];
        Arrays.fill(res , Integer.MAX_VALUE);

        for(int i = 0 ; i < n ; i++){
            if(arr[i] == 0){
                //its a pot hole 
                //We go left and right till we encounter ends or another pot hole 
                int l = i-1 ; 
                int htPrev = 0;
                int r = i+1 ; 
                while(l >= 0 ){
                    if(arr[l] == 0) break ; 
                    if(l == i-1){
                        htPrev = arr[l];
                        res[l] = arr[l]/p ; 
                    }else{
                        if(arr[l] < htPrev){
                            res[l] = res[l+1];
                        }else{
                            res[l] = arr[l]/p ; 
                        }
                    }
                    l-- ;
                }
                while(r < n){
                    if(arr[r] == 0) break ; 
                    if(r == i+1){
                        htPrev = arr[r];
                        res[r] = arr[r]/p ; 
                    }else{
                        if(arr[r] < htPrev){
                            arr[r] = arr[r-1];
                        }else{
                            arr[r] = arr[r]/p ; 
                        }
                    }
                    r++ ;
                }
            }
        }
    }
}

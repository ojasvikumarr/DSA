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
		    while(t-- > 0){
		        int n = sc.nextInt();
                int[] arr = new int[n];
                for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
                solve(arr, n);
		    }
		sc.close();
	}

    public static void solve(int[] arr , int n){
        int[] hill = new int[n];
        for(int i = 1 ; i < n-1 ; i++){
            if((arr[i-1] < arr[i] && arr[i] > arr[i+1]) || 
              ( arr[i-1] > arr[i] && arr[i] < arr[i+1] ) ){
                hill[i] = 1 ; 
            }
            // System.out.print(hill[i] + " ");
        }
        // System.out.println(n);
        // for(int i = 0 ; i < n ; i++){
        //     System.out.print(hill[i] + " ");
        // }
        // System.out.println();
        int l = 0 ; 
        int r = 0 ; 
        long val = 0 ; 
        long friends = 0 ; 
        while(r < n){
            if(hill[r] == 1) val++  ;
            if(val == 2){
                //we move l 
                // friends += (r-l) ;
                while( val == 2 && l < r){
                    val -= hill[l];
                    hill[l] = 0 ; 
                    if(val != 2) break ;
                    // System.out.println(r + " " + l);
                    friends += (r-l) ;
                    l++ ; 
                }
            }
            // System.out.println("val  " +val);
            r++ ; 
        }

        // while(r < n){
        //     if(hill[r] == 1) val++ ; 
        //     while(val > 2){
        //         val -= hill[l];
        //         l++ ;
        //     }
        //     if(val == 2){
        //         friends += (r - l);
        //     }
        //     r++ ; 
        // }
        // while(l < r){
        //     friends += (r-l);
        //     l++ ; 
        // }
        // System.out.println(r);
        if(r == n) r-- ; 
        while(l < r){
            // System.out.println(r + " " + l );
            friends += (r-l) ;
            // val -= hill[l];
            l++ ; 
        }
        System.out.println(friends);
        return ; 
    }
}

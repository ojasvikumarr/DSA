package CodeChef;

import java.util.*;

public class Starters173 {
    
class Codechef
{
	public static void main (String[] args) 
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int[] a = new int[n];
		    int[] b = new int[m];
		    int mini = Integer.MAX_VALUE ; 
		    int idx = 0 ; 
		    for(int i = 0 ; i < n ; i++) a[i] = sc.nextInt();
		    for(int i = 0 ; i < m ; i++){
		         b[i] = sc.nextInt();
		         if(mini > b[i]){
    	            mini = Math.min(mini , b[i]);
    	            idx = i ; 
	             }
		    }
		    solve(a , b , n , m , mini ,idx);
		}
		sc.close();
	}
	public static void solve(int[] a , int[] b , int n , int m , int mini , int idx){
	    //First sort the array b 
	    int[] B = new int[m];
	    for(int i = 0 ; i < m ; i++){
	        B[i] = b[(idx+i)%m];
	    }
	    
	    //Now we have sorted B 
	   // ??Now we start comparing 
	   
	   int h = 0 ; //For a 
	    if(m == 1){
        for(int i = 0 ; i < n; i++){
            if(a[i] > b[0]){
                a[i] = b[0];
            }
        }
        // System.out.println("HEllo");
        }else{
        //If aray b is 2 
           while(h < n){
               if(B[0] <= a[h]){
                   //We lay down B 
                   int i = h ;
                   int k = 0 ; 
                   if(n-i >= m){
                       boolean flag = false ; 
                       //Checking if Array B is smaller than A 
                       while(k < m && i < n){
                           if(B[k] < a[i]){
                            flag = true ; 
                            break ; 
                           }
                           k++ ; 
                           i++ ; 
                       }
                       i = h ; 
                       k = 0 ;
                       //Dominos Effect 
                       //No Chance and We have to lay Down B till end 
                       if(flag == true){
                           while(i < n - m){
                                a[i] = B[0];
                                i++ ;
                           }
                           while(i < n && k < m){
                                a[i] = B[k];
                                i++; 
                                k++ ; 
                           }
                           break ; 

                       }
                   
                   }
               }
               h++ ; 
           }
    }
	   
	   for(Integer it : a){
	       System.out.print(it + " ");
	   }
	   System.out.println();
	   return ; 
	}
}

}

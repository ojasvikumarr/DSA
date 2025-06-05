import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.StringBuilder ;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		    int t = sc.nextInt();
		    StringBuilder sb = new StringBuilder();
		    while(t-- > 0){
		        int n = sc.nextInt();
		        if(n == 2){
		            sb.append("2 1");
		        }else if(n == 3){
		            sb.append("2 1 3");
		        }else if(n == 4){
		            sb.append("3 1 4 2");
		        }else if(n == 5){
		            sb.append("3 2 1 5 4 ");
		        }else{
		            sb.append("3 2 1 5 4 ");
		            for(int i = 6 ; i <= n ; i++){
		                if((i+1)% 2 != 0 && i+1 <= n){
		                    sb.append((i+1)+" "+i +" ");
		                    i++ ;
		                }else{
		                    sb.append(i+" ");
		                }
		            }
		        }
		        sb.append("\n");
		    }
		    System.out.println(sb.toString());
		sc.close();
	}
// 	public static boolean isPrime(int n){
// 	    if(n == 0 || n == 1) return false ;
// 	    for(int i = 2 ; i*i <= n ; i++){
// 	        if(n%i == 0){
// 	            return false ;
// 	        }
// 	    }
// 	    return true ;
// 	}
	
}

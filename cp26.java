import java.util.*;
import java.lang.StringBuilder ; 

class cp26
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
		 String a = sc.next();
         String b = sc.next();
		 solve(a , b);
		//  solve(arr , n , x);
		}
		sc.close();
	}
	public static void solve(String a , String b ){
        int n = a.length();
        int m = b.length();

        if(n <= m && !a.equals(b)){
            System.out.println(-1);
            return ; 
        }
        //Now freq map  
        int[] freqA = new int[26];
        int[] freqB = new int[26];

        for(char c : a.toCharArray()){
            freqA[c-'a']++ ;
        }
        for(char c : b.toCharArray()){
            freqB[c-'a']++ ;
        }

        for(int i = 0 ; i < 26 ; i++){
            if(freqA[i] < freqB[i]){
                System.out.println(-1);
                return ; 
            }
        }

        //Now we do the summing of costing 
        int cost = 0 ;
        StringBuilder A = new StringBuilder(a);
        int i = n-1 ; 
        int j = m-1 ; 
        while(i>= 0 && j >= 0){
            if(a.charAt(i) == b.charAt(j)){
                A.setCharAt(i , '0');
                j-- ;
            }
            i-- ; 
        }
        // System.out.println(A);
        //Now we have marked our string b in a 
        //We will count our cost 
        int idx = 1 ; 
        i = 0 ; 
        j = 0 ; 
        while(i < n){
            j = i ; 
            while(i < n && A.charAt(i) != '0') i++ ; 
            cost += ((i - j)*idx) ; 
            j = i ;
            while( i < n && A.charAt(i) == '0') i++ ;
            idx = i - j +1 ; 
        }
        System.out.println(cost);
        return ; 
    }
}

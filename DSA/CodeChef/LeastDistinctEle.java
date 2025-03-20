package CodeChef;
import java.util.*;

class LeastDistinctEle
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
		        solve(arr , n);
		    }
		sc.close();
	}
	public static void solve(int[] arr , int n ){
	    Map<Integer , Integer> map = new HashMap<>();
	    int[] prefix = new int[n+1];
	    for(int i = 0 ; i < n ; i++){
	        if(map.containsKey(arr[i])){
	            int idx = map.get(arr[i]) ; 
	            prefix[i+1] = Math.min(prefix[idx+1] , prefix[i]+ (arr[i-1] == arr[i] ? 0 : 1) ) ;
                map.put(arr[i] , i);
	        }else{
	            map.put(arr[i] , i);
	            prefix[i+1] = prefix[i] + 1 ;
	        }
	    }
	    System.out.println(prefix[n]);
	    return ; 
	}
}

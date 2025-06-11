import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            int maxi = 0 ;
            for(int i = 0 ; i < n-1 ; i++){
                if(arr[i] > arr[i+1]){
					int val = check(arr[i] , arr[i+1]);
					arr[i+1] |= val ; 
                    maxi = Math.max(maxi , val);
                }
            }
            sb.append(maxi);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
	}
	public static int check(int a , int b ){
	    int val = 0 ;
	    for(int i = 31 ; i >= 0 ; i--){
	        if((a&(1<<i)) != 0){
	            //it is set 
	            if((b&(1<<i)) != 0){
	                continue ;
	            }else{
	                val |= (1<<i);
	            }
	        }else if((b&(1<<i)) != 0){
	            break; 
	        }
	    }
	    return val ; 
	}
}

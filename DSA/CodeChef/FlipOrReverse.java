package CodeChef;
import java.util.* ; 
public class FlipOrReverse {
   
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		    int t = sc.nextInt();
		    while(t-- > 0){
		        int n = sc.nextInt();
		        String A = sc.next();
		        String B = sc.next();
		        //we'll be performing only the first operation 
		        List<int[]> oper = new ArrayList<>();
		        int k = 0 ; 
		        int L = -1 ; 
		        int R = -1 ; 
		        for(int i = 0 ; i < n; i++){
		            //traversing over the two arrays simul
		            if(A.charAt(i) != B.charAt(i)){
		                L = i ; 
		                while(i < n && A.charAt(i) != B.charAt(i)) i++ ; 
		                R = i-1 ; 
		                oper.add(new int[]{L , R});
		                k++ ; 
		            }else{
		                continue ; 
		            }
		        }
		        System.out.println(k);
		        for(int[] arr : oper){
		            System.out.println(1 + " " + (arr[0]+1) + " " + (arr[1]+1));
		        }
		    }
		sc.close();
	}
}


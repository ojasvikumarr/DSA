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
		        PriorityQueue<Integer> pq = new PriorityQueue<>();
                int[] arr = new int[n];
                int maxi = 0 ; 
		        for(int i = 0 ; i < n ; i++){
                    arr[i] = sc.nextInt();
                    maxi = Math.max(maxi , arr[i]);
		        }
                for(int ele : arr){
                    pq.add(ele);
                }
                // while(!pq.isEmpty()){
                //     System.out.print(pq.poll() + "_");
                // }
                // System.out.println(pq);
                
		        System.out.println(Math.min(solve(pq , n), maxi));
		    }
		sc.close();
	}
	public static int solve(PriorityQueue<Integer> pq , int n){
	    
	    int res = 0 ; 
	    while(!pq.isEmpty()){
	        int top = pq.poll();
	        int count = 1 ; 
            // System.out.println(pq.peek());
            while(!pq.isEmpty() && pq.peek() == top){
                count++ ;
                pq.poll();
            }
            if(count >= top){
                PriorityQueue<Integer> temp = new PriorityQueue<>();
                    for(int ele : pq){
                        // System.out.print(ele + " - ");
                        temp.offer(Math.max(ele-top , 0 ));
                    }
                    pq = temp ; 
	                res += top ; 
            }else{
                res += count ; 
            }
	       // if(pq.peek() == top){
	       //     count++ ; 
	       //     pq.poll();
        //         if(pq.isEmpty()){
        //             if(count >= top){
	       //             res += top ; 
        //             }else{
        //                 res += count ; 
        //             }
        //         }
	       // }else{
	       //     //its not equal 
	       //     if(count >= top){
        //             PriorityQueue<Integer> temp = new PriorityQueue<>();
        //             for(int ele : pq){
        //                 // System.out.print(ele + " - ");
        //                 temp.offer(ele-top);
        //             }
        //             pq = temp ; 
	       //         res += top ; 
	       //     }else{
	       //         res += count ; 
	       //     }
        //         top = pq.poll();
        //         count = 1 ; 
        //         if(pq.isEmpty()){
        //             if(count >= top){
	       //             res += top ; 
        //             }else{
        //                 res += count ; 
        //             }
        //         }
	    }
	    return res ;
	}
}

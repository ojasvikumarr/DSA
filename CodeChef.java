import java.util.*;
import java.lang.*;
import java.io.*;

class CodeChef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
            int n = sc.nextInt();
            List<Integer> x = new ArrayList<>();
            int[] y = new int[n];
            for(int i =0 ; i < n ;i++){
                x.add(sc.nextInt());
            }
            for(int i = 0 ; i < n ; i++){
                y[i] = sc.nextInt() ; 
            }
            solve(x, y , n);
		}
		sc.close();
	}
    public static void solve(List<Integer> x, int[] y , int n){
        int pivot = y[0];
        int index = x.indexOf(pivot) + 1 ; 
        Collections.sort(x , (a , b) ->{
            int A = Math.abs(a-pivot);
            int B = Math.abs(b-pivot);
            if(A == B){
                return a - b ; 
            }
            return A-B ; 
        }) ; 
        for(int i = 0 ; i < n ; i++){
            if(x.get(i) != y[i]){
                System.out.println(-1);
                return ;
            }
        }
        System.out.println(index);
        return ; 
    }
}

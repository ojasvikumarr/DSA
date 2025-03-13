package CodeChef;

import java.util.Scanner;

public class FXY0110 {
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
		    int n = sc.nextInt();
		    long res = 0 ; 
		    for(int i = 0 ; i <= n/2 ; i++){
		        res += (long)i*(n-i) + 1; 
		    }
		    System.out.println(res);
		}
		sc.close();
	}
}

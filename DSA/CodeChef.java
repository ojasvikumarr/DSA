import java.util.*;
import java.lang.*;
import java.io.*;
public class CodeChef {
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0 ; tc < t ; tc++){
		    int n = sc.nextInt();
		    int[] arr = new int[n];
		    for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
		    System.out.println(helper(arr , n));
		}
		sc.close();
	}

    public static int helper(int[] arr, int n) {
        int low = 0, high = n; // Binary search range
        int result = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canStabilize(arr, n, mid)) {
                result = mid; // Update the result to the current midpoint
                high = mid - 1; // Try for a smaller number of seconds
            } else {
                low = mid + 1; // Increase the guess
            }
        }

        return result;
    }

    public static boolean canStabilize(int[] arr, int n, int seconds) {
        int[] temp = arr.clone(); // Create a temporary array to simulate
        for (int i = n - 1; i > 0; i--) {
            if (temp[i] < temp[i - 1]) {
                // If the difference exceeds the allowed decrease in 'seconds', it's not possible
                int requiredDecrease = temp[i - 1] - temp[i];
                if (requiredDecrease > seconds) {
                    return false;
                }
                temp[i - 1] -= requiredDecrease; // Reduce the larger element
            }
        }
        return true;
    }
}

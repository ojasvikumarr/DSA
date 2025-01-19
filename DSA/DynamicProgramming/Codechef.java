package DynamicProgramming;
import java.util.* ;
public class Codechef
{
    String result ;
	public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // Number of test cases
        for (int tc = 0; tc < t; tc++) {
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                if (i != 2) { // Read all except a3
                    arr[i] = sc.nextInt();
                }
            }
            System.out.println(maxFibonacciness(arr));
        }
        sc.close();
    }

    public static int maxFibonacciness(int[] arr) {
        int a3_1 = arr[0] + arr[1]; 
        int a3_2 = arr[4] - arr[3]; 

        return Math.max(fibonacciness(arr, a3_1), fibonacciness(arr, a3_2));
    }

    public static int fibonacciness(int[] arr, int a3) {
        int count = 0;
        arr[2] = a3; // Set a3
        // Check conditions
        if (arr[2] == arr[0] + arr[1]) count++; // i=1
        if (arr[3] == arr[1] + arr[2]) count++; // i=2
        if (arr[4] == arr[2] + arr[3]) count++; // i=3
        return count;
    }
}



import java.util.Scanner;

public class ConstructPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Length of the permutation

            if (n == 1) {
                // For n = 1, the only permutation is [1]
                System.out.println("1");
            } else {
                // Generate the permutation [2, 3, ..., n, 1]
                for (int i = 2; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.print("1\n");
            }
        }

        sc.close();
    }
}

import java.util.Scanner;

public class ClosestPoint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of points in the set
            int[] points = new int[n];
            
            // Read the points
            for (int i = 0; i < n; i++) {
                points[i] = sc.nextInt();
            }
            
            int minGap = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                minGap = Math.min(minGap, points[i] - points[i - 1]);
            }
            
            // Check if it's possible to add a new point within the smallest gap
            boolean possible = false;
            for (int i = 1; i < n; i++) {
                if (points[i] - points[i - 1] > minGap) {
                    possible = true;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}

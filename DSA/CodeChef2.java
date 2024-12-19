import java.util.* ;

public class CodeChef2 {

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            if (helper(str, n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        sc.close();
    }

    public static boolean helper(String str, int n) {
        int same = 0;
        int trailer = -1;

        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                if (trailer == -1) {
                    trailer = i; 
                }
            } else {
                if (trailer != -1) {
                    same++;
                    trailer = -1;
                }
            }
            if (i < n - 2 && str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 1) == str.charAt(i + 2)) {
                return false;
            }
        }
        if (trailer != -1) {
            same++;
        }
        return same <= 1;
    }
}
}

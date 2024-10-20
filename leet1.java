import java.util.* ;
public class leet1 {

    public String largestPalindrome(int n, int k) {
        long upperHalf = (long) Math.pow(10, (n + 1) / 2) - 1;
        long lowerBound = (long) Math.pow(10, (n - 1) / 2);

        for (long firstHalf = upperHalf; firstHalf >= lowerBound; firstHalf--) {
            String fHalf = Long.toString(firstHalf);
            StringBuilder palin = new StringBuilder(fHalf);
            if (n % 2 != 0) {
                palin.append(new StringBuilder(fHalf.substring(0, fHalf.length() - 1)).reverse());
            } else {
                palin.append(new StringBuilder(fHalf).reverse());
            }
            long palindrome = Long.parseLong(palin.toString());
            if (palindrome % k == 0) {
                return palin.toString();
            }
        }
        return "";
    }
}

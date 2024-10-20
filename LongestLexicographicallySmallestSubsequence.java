import java.util.*;

public class LongestLexicographicallySmallestSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // Length of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Use LinkedHashSet to maintain the order of first occurrence and unique elements
            LinkedHashSet<Integer> uniqueElements = new LinkedHashSet<>();
            for (int num : a) {
                uniqueElements.add(num);
            }

            // Create a list from the unique elements
            List<Integer> result = new ArrayList<>(uniqueElements);

            // Create modified version of the result list for comparison
            List<Integer> modifiedResult = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                if (i % 2 == 0) { // 0-based index means 1st, 3rd, 5th, ... are odd positions
                    modifiedResult.add(-result.get(i));
                } else {
                    modifiedResult.add(result.get(i));
                }
            }

            // Determine the lexicographically smaller sequence
            if (compareLexicographically(modifiedResult, result) < 0) {
                result = modifiedResult;
            }

            // Output the size of the sequence and the elements in order
            System.out.println(result.size());
            for (int i = 0; i < result.size(); i++) {
                System.out.print(Math.abs(result.get(i)) + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    // Helper method to compare two lists lexicographically
    private static int compareLexicographically(List<Integer> list1, List<Integer> list2) {
        int size1 = list1.size();
        int size2 = list2.size();
        int minSize = Math.min(size1, size2);

        for (int i = 0; i < minSize; i++) {
            int cmp = list1.get(i).compareTo(list2.get(i));
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(size1, size2);
    }
}

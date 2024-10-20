import java.util.*;

public class PrintAllSubsequences {
    public static void PrintAllSubs(int idx, int arr[], ArrayList<Integer> ans, int n) {
        if (idx == n) {
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i) + " , ");
            }
            if (ans.size() == 0) {
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        ans.add(arr[idx]);
        PrintAllSubs(idx + 1, arr, ans, n);
        ans.remove(ans.size() - 1);
        PrintAllSubs(idx + 1, arr, ans, n);
    }

    public static void PrintDesiredSum(int idx, int arr[], ArrayList<Integer> ans, int n, int sum, int expSum) {
        if (idx == n) {
            if (sum == expSum) {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i) + " | ");
                }
                System.out.println();
            }
            return;
        }
        // pick
        ans.add(arr[idx]);
        sum += arr[idx];
        PrintDesiredSum(idx + 1, arr, ans, n, sum, expSum);
        ans.remove(ans.size() - 1);
        sum -= arr[idx];
        PrintDesiredSum(idx + 1, arr, ans, n, sum, expSum);
    }

    public static boolean PrintOneSum(int idx, int arr[], ArrayList<Integer> ans, int n, int sum, int expSum) {
        if (idx == n) {
            if (sum == expSum) {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(ans.get(i) + " | ");
                }
                System.out.println();
                return true;
            } else
                return false;
        }
        // pick
        ans.add(arr[idx]);
        sum += arr[idx];
        if (PrintOneSum(idx + 1, arr, ans, n, sum, expSum) == true) {
            return true;
        }
        ans.remove(ans.size() - 1);
        sum -= arr[idx];
        if (PrintOneSum(idx + 1, arr, ans, n, sum, expSum) == true) {
            return true;
        }
        return false;
    }

    public static int CountRecur(int idx, int arr[], int n, int sum, int expSum) {
        if (idx == n) {
            if (sum == expSum) {
                return 1;
            } else {
                return 0;
            }
        }
        sum += arr[idx];
        int l = CountRecur(idx + 1, arr, n, sum, expSum);
        sum -= arr[idx];
        int r = CountRecur(idx + 1, arr, n, sum, expSum);
        return l + r;
    }

    public static void main(String args[]) {
        int arr[] = { 4, 1, 2, 5, 6, 3 };
        int n = arr.length;
        int sum = 0;
        int expSum = 8;
        PrintAllSubs(0, arr, new ArrayList<>(), n);
        PrintDesiredSum(0, arr, new ArrayList<>(), n, sum, expSum);
    }
}

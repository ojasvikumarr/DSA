package SegmentTree;

import java.util.Scanner;
public class maxSubarrayQuery {

    static class Node {
        long sum, maxPrefix, maxSuffix, maxSubarray;
        Node(long val) {
            sum = maxPrefix = maxSuffix = maxSubarray = val;
        }
    }

    static int n;
    static Node[] segTree;
    static long[] lazy;

    public static void build(int idx, int l, int r, long[] arr) {
        if (l == r) {
            segTree[idx] = new Node(arr[l]);
            return;
        }
        int mid = (l + r) / 2;
        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);
        segTree[idx] = merge(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }

    public static void rangeUpdate(int idx, int l, int r, int ql, int qr, long val) {
        propagate(idx, l, r);
        if (l > qr || r < ql) return;
        if (l >= ql && r <= qr) {
            lazy[idx] = val;
            propagate(idx, l, r);
            return;
        }
        int mid = (l + r) / 2;
        rangeUpdate(2 * idx + 1, l, mid, ql, qr, val);
        rangeUpdate(2 * idx + 2, mid + 1, r, ql, qr, val);
        segTree[idx] = merge(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }

    public static Node query(int idx, int l, int r, int ql, int qr) {
        propagate(idx, l, r);
        if (l > qr || r < ql) return new Node(0);
        if (l >= ql && r <= qr) return segTree[idx];
        int mid = (l + r) / 2;
        Node left = query(2 * idx + 1, l, mid, ql, qr);
        Node right = query(2 * idx + 2, mid + 1, r, ql, qr);
        return merge(left, right);
    }

    public static void propagate(int idx, int l, int r) {
        if (lazy[idx] != 0) {
            long val = lazy[idx];
            segTree[idx] = new Node(val * (r - l + 1));
            if (l != r) {
                lazy[2 * idx + 1] = val;
                lazy[2 * idx + 2] = val;
            }
            lazy[idx] = 0;
        }
    }

    public static Node merge(Node left, Node right) {
        Node res = new Node(0);
        res.sum = left.sum + right.sum;
        res.maxPrefix = Math.max(left.maxPrefix, left.sum + right.maxPrefix);
        res.maxSuffix = Math.max(right.maxSuffix, right.sum + left.maxSuffix);
        res.maxSubarray = Math.max(Math.max(left.maxSubarray, right.maxSubarray), left.maxSuffix + right.maxPrefix);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();

        segTree = new Node[4 * n];
        lazy = new long[4 * n];

        build(0, 0, n - 1, arr);

        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) { // Range update
                int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
                long val = sc.nextLong();
                rangeUpdate(0, 0, n - 1, l, r, val);
            } else { // Query max subarray sum
                System.out.println(query(0, 0, n - 1, 0, n - 1).maxSubarray);
            }
        }
        sc.close();
    }

}

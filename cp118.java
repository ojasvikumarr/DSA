import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp118{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());  
            }
            init(arr);
            while(q-- > 0){
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if(type == 1){
                    int k = Integer.parseInt(st.nextToken()) - 1;
                    long u = Long.parseLong(st.nextToken());
                    updateQuery(arr, 0, k, u, 0, n-1);
                }else{
                    int a = Integer.parseInt(st.nextToken()) - 1;
                    int b = Integer.parseInt(st.nextToken()) - 1;
                    sb.append(rangeSum(0, 0, n-1, a, b)).append("\n");
                }
            }
        // }
        System.out.println(sb.toString());

    }

    static long[] segTree; 
    static int n ; 
    public static void init(long[] arr) {
        n = arr.length;
        segTree = new long[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }
    public static void buildTree(long[] arr, int i, int l, int r) {
        if (l == r) {
            segTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(arr, 2 * i + 1, l, mid);
        buildTree(arr, 2 * i + 2, mid + 1, r);
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }
    public static void updateQuery(long[] arr, int i, int idx, long val, int l, int r) {
        if (l == r) {
            segTree[i] = val;
            arr[idx] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateQuery(arr, 2 * i + 1, idx, val, l, mid);
        } else {
            updateQuery(arr, 2 * i + 2, idx, val, mid + 1, r);
        }
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }
    public static long rangeSum(int i, int l, int r, int start, int end) {
        if (l > end || r < start) {
            return 0;
        }
        if (l >= start && r <= end) {
            return segTree[i];
        }
        int mid = l + (r - l) / 2;
        long left = rangeSum(2 * i + 1, l, mid, start, end);
        long right = rangeSum(2 * i + 2, mid + 1, r, start, end);
        return left + right;
    }
}
import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp121{
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
                    int a = Integer.parseInt(st.nextToken()) - 1;
                    int b = Integer.parseInt(st.nextToken()) - 1;
                    long u = Long.parseLong(st.nextToken());
                    rangeUpdate(0 , u , 0 , n-1 , a ,b);
                }else{
                    int k = Integer.parseInt(st.nextToken()) - 1;
                    sb.append(pointQuery(0, k , 0, n-1)) ;
                    sb.append("\n");
                }
            }
        // }
        System.out.println(sb.toString());

    }


    static Pair[] segTree; 
    static long[] lazyTree; 
    static int n ; 
    public static void init(long[] arr) {
        n = arr.length;
        segTree = new Pair[4 * n];
        lazyTree = new long[4 * n];
        buildTree(arr, 0, 0, n - 1);
    }

    public static void buildTree(int[] arr , int i , int l , int r){
        if(l == r){
            segTree[i] = new Pair(arr[l] , arr[l]);
            return ; 
        }
        int mid = l + ( r - l )/2 ;
        buildTree(arr , 2*i + 1 , l , mid);
        buildTree(arr , 2*i + 2 , mid+1 , r);
        segTree[i] = helper(segTree[2*i + 1] , segTree[2*i + 2]);
    }
    public static Pair helper(Pair left , Pair right){
        Pair ans = new Pair(0 , 0);
        ans.sum = left.sum + right.sum ; 
        ans.sum = Math.max(ans.sum , left.max + right.max);

        ans.max = Math.max(left.max , right.max);
        return ans ;
    }

    public static void updateQuery(int i , int val , int l , int r){
        if(l == r){
            segTree[i].max = segTree[i].sum = val ;
            return ;
        }
        int mid = l + ( r - l )/2 ; 
        if(idx <= mid){
            updateQuery(2*i + 1, val , l , mid);
        }else{
            updateQuery(2*i + 2 , val , mid + 1, r);
        }
        segTree[i] = helper(segTree[2*i + 1] , segTree[2*i+2]);
    }

    public static Pair rangeQuery(int i , int l , int r , int start , int end){
        if(l > end || r < start){
            return new Pair(0 , 0 );
        }

        if(l >= start && r <= end){
            return segTree[i];
        }
        int mid = l + (r - l)/2 ; 
        Pair left = rangeQuery(2*i + 1 , l , mid , start , end);
        Pair right = rangeQuery(2*i + 2 , mid + 1 , r , start , end);
        return helper(left , right);
    }
    public static Pair{
        long sum ; 
        long max ; 
        Pair(long s, long m){
            this.sum = s ; 
            this.max = m ;
        }
    }

}
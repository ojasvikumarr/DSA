import java.util.* ; 
import java.lang.* ; 
import java.io.* ; 
import java.util.Arrays ;
public class cp114{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long[] prefixSum = new long[n+1];
            prefixSum[0] = 0;
            for(int i = 0 ; i < n ; i++){
                prefixSum[i+1] = prefixSum[i] + arr[i];
            }

            Map<Long , List<Integer>> map = new HashMap<>();
            for(int i = 0 ; i <= n ; i++){
                map.putIfAbsent(prefixSum[i], new ArrayList<>());
                map.get(prefixSum[i]).add(i);
            }
            init(arr);
            long res = 0 ; 
            for(int r = 1 ; r <= n ; r++){
                long target = prefixSum[r] - s ; 
                if(map.containsKey(target)){
                    for(int idx : map.get(target)){
                        if(idx < r && rangeMax(0 , 0 , n-1 , idx , r-1) == x){
                            res++ ; 
                        }
                    }
                }
            }
            sb.append(res);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    static int[] segTree ; 
    public static void init(int[] arr){
        int n = arr.length ; 
        segTree = new int[4*n];
        buildTree(arr , 0 , 0  ,n-1);
    }
    public static void buildTree(int[] arr , int idx , int l , int r){
        if(l == r){
            segTree[idx] = arr[l];
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        buildTree(arr , 2*idx + 1 , l , mid);
        buildTree(arr , 2*idx + 2 , mid + 1 , r);
        segTree[idx] = Math.max(segTree[2*idx + 1] , segTree[2*idx + 2]);
        return  ;
    }
    public static int rangeMax(int idx , int l , int r , int start , int end){
        if(l > end || r < start){
            return Integer.MIN_VALUE ;
        }
        if(l >= start && r <= end){
            return segTree[idx];
        }
        int mid = l + (r - l)/2 ; 
        int leftMax = rangeMax(2*idx + 1 , l , mid , start , end);
        int rightMax = rangeMax(2*idx + 2 , mid + 1 , r , start , end);
        return Math.max(leftMax , rightMax);
    }
}
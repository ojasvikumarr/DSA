import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        if(m == n){
            System.out.println(0);
            return ; 
        }

        Arrays.sort(arr);

        long[] gaps = new long[n-1];

        for(int i = 0 ; i < n ; i++){
            gaps[i] = arr[i+1] - arr[i];
        }

        init(n);


        
        br.close();
    }
    static int[] segTree; 
    public static void init(int n ,long[] gaps){
        segTree = new int[4*n] ; 
        buildTree();
    }
    public static void buildTree(int i , int l , int r , long[] gaps){
        if(l == r){
            segTree[i] = l ; 
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        buildTree(2*i + 1 , l , mid , gaps);
        buildTree(2*i + 2 , mid +1 , r , gaps);
        int left = segTree[2*i + 1];
        int right = segTree[2*i + 2];
        if(gaps[left] >= gaps[right]){
            segTree[i] = left ;
        }else{
            segTree[i] = right ;
        }
    }

    public static int query(int i , int l , int r , int start , int end , long[] gaps){
        if(l > end || r < start) return -1 ; 
        if(l >= start && r <= end){
            return segTree[i];
        }

        int mid = l + (r - l)/2 ; 
        int left = query(2*i +1 , l , mid , start , end , gaps);
        int right = query(2*i +2 , mid  + 1 , r , start , end , gaps);
        if(left == -1){
            return right ; 
        }else if(right == -1){
            return left ;
        }
        if(gaps[left] >= gaps[right]) return left ; 
        return right ;
    }

    public static long[] bestSplit(int l , int r , long[] arr , long[] gaps , int gN){
        int n = arr.length ; 
        long orginal = cost(arr[l] , arr[r]);
        int k = query(0 , 0 , n-1 , l , r-1 , gaps);

        long leftCost = cost(arr[l] , arr[k]);
        long rightCost = cost(arr[k+1] ,arr[r] );
        long saving = orginal - leftCost - rightCost ; 
        return new Segment(l , r , k , saving);
    }

    public static long ocst(long l , long r){
        long span = r - l ; 
        if(span <= 2) return 0 ; 
        long need = (span + 1)/2 ; 
        int x = 0 ; 
        long power = 1 ; 
        while(power < need){
            power = power<<1 ; 
            x++ ; 
        }
        return x ; 
    }

}






















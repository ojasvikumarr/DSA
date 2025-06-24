import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp124{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if(type == 1){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                sb.append(rangeSumSq(0 ,l, r ,0 , n-1));
                sb.append("\n");
            }else{
                int val = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                rangeUpdate(arr , val ,0 , l , r , 0 , n-1);
            }
        }
        System.out.println(sb.toString());
        br.close();
    }

    static class Node{
        long sum ; 
        long sumSq ; 
        public Node(long s , long ss){
            this.sum = s; 
            this.sumSq = ss ;
        }
    }
    static Node segTree[];
    static int lazyTree[];
    public static void init(int[] arr){
        int n = arr.length ;
        segTree = new Node[n*4];
        lazyTree = new int[4*n];
        buildTree();
    }
    public static void buildTree(int[] arr, int i , int l , int r ){
        if(l == r){
            segTree[i] = new Node(arr[l] , 1L*arr[l]*arr[l]);
            return ; 
        }
        int mid = l + (r - l)/2 ; 
        buildTree(arr , 2*i + 1 , l , mid );
        buildTree(arr , 2*i + 2 , mid + 1 , r);
        segTree[i] = merge(segTree[2*i+1] ,segTree[2*i+2]);
    }
    public static int rangeSumSq(int i , int l , int r , int start , int end){
        propogate(i , l , r);
        if(l > end || r < start){
            return 0; 
        }
        if(l >= start && r <= end){
            return segTree[i].sumSq ;
        }
        int mid = l + (r - l)/2 ; 
        int left = 0 ; 
        int right = 0 ; 
        left = rangeSumSq(2*i+1 , l , mid , start , end);
        right = rangeSumSq(2*i + 2 , mid + 1,  r , start , end);
        return left + right ; 
    }
    public static void rangeUpdate(int[] arr , int val , int i , int l , int r , int start ,int end){
        propogate(i , l , r);
        if(l > end || r < start){
            return ; 
        }
        if(l >= start && r <= end){
            segTree[i].sumSq += (r-l+1)*1L*val*val + 2L*val*(segTree[i].sum);
            segTree[i].sum += (r-l+1)*1L*val ;
            if(r != l){
                lazyTree[2*i+1] += val ; 
                lazyTree[2*i+2] += val ;
            }
            return ;
        }
        int mid = l + (r - l)/2 ; 
        rangeUpdate(arr , val , 2*i+1 , l , mid , start ,end);
        rangeUpdate(arr , val , 2*i+2 , mid+1 , r , start , end);
        segTree[i] = merge(segTree[2*i + 1] , segTree[2*i + 2]);
    }
    public static void propogate(int i , int l , int r){
        if(lazyTree[i] == 0) return ;
        segTree[i].sumSq += (r-l+1)*lazyTree[i]*lazyTree[i] + lazyTree[i]*2*(segTree[i].sum);
        segTree[i].sum += (r-l+1)*lazyTree[i]*1L ; 
        if(l != r){
            lazyTree[2*i+1] += lazyTree[i];
            lazyTree[2*i+!] += lazyTree[i];
        }
        lazyTree[i] = 0 ; 
    }
    public static Node merge(Node a , Node b){
        long sum = a.sum + b.sum ; 
        long sqSum = a.sumSq + b.sumSq ;
        Node newNode = new Node(sum , sqSum);
        return newNode ; 
    }
}
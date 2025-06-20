import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp117{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            this.n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());  
            }
            while(q-- > 0){
                st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if(type == 1){
                    int l = Integer.parseInt(st.nextToken()) - 1;
                    int r = Integer.parseInt(st.nextToken()) - 1 ; 


                }
            }
        }
    }

    int[] segTree; 
    boolean[] lazyTree ;
    int n ; 
    public void init(int[] arr){
        segTree = new int[4*n];
        lazyTree = new boolean[4*n];
        buildTree();
    }
    public void buildTree(int[] arr , int i , int l , int r){
        if(l == r){
            segTree[i] = arr[l];
            return ; 
        }
        int mid = l + (r - l)/2 ;
        buildTree(arr , 2*i + 1 , l , mid);
        buildTree(arr , 2*i + 2 , mid + 1 , r);
        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public void rangeUpdate(int i , int l , int r , int start , int end){
        if(l > end || r < start){
            return ; 
        }
        if(l == r){
            segTree[i] = (segTree[i] == 0)? 1 : 0;
            return ;
        }else if(start <= l && r <= end ){
            lazy[i] = !lazy[i];
            propogate();
        }

        int mid = l + ( r - l )/2 ; 
        rangeUpdate(2*i + 1 , l , mid , start , end);
        rangeUpdate(2*i+2 , mid + 1 , r , start , end);
        segTree[i] = segTree[2*i + 1] + segTree[2*i+2];
    }
    public void propogate(int i , int l , int r){
        if(lazyTree[i] == false) return ; 

        if(l == r){
            segTree[i] = (segTree[i] == 0 ? 1 : 0) ; 
        }else{
            int count = r - l + 1; 
            segTree[i] = count - segTree[i];
            lazyTree[2*i+1] = !lazyTree[2*i+1];
            lazyTree[2*i+2] = !lazyTree[2*i+2];
        }
    }
}
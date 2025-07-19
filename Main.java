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
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long[][] arr = new long[h+1][w+1];
        for(int i = 1 ; i <= h ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= w ; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[] p = new long[h+w];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= h + w-1 ; i++){
            p[i] = Long.parseLong(st.nextToken());
        }
        map.clear();
        Pair ans = dfs(arr , p , h , w);

        System.out.println(ans.req);
        br.close();
    }
    public static class Pair{
        long req ; 
        long sum ; 
        public Pair(long r , long s){
            this.req = r ; 
            this.sum = s ;
        }
    }
    static Map<Long , Pair> map = new HashMap<>();
    
    public static Pair dfs(long[][] arr , long[] p , int i , int j ){
        if(i == 0 || j == 0){
            return new Pair(Long.MAX_VALUE/2 , Long.MIN_VALUE/2);
        }

        long key =( ((long)i<<32) | j) ; 
        if(map.containsKey(key)){
            return map.get(key);
        }

        int k = i + j - 1; 
        long gain = arr[i][j] - p[k];
        Pair res ; 
        if(i == 1 && j == 1){
            long sum = gain ; 
            long req = -1 ; 
            if(sum < 0){
                req = - sum ; 
            }else{
                req = 0 ; 
            }
            res = new Pair(req , sum);
        }else{
            Pair fromTop = dfs(arr , p , i-1 , j);
            Pair fromLeft = dfs(arr , p ,i , j-1);

            res = fromTop.req <= fromLeft.req ? fromTop : fromLeft ; 

            long newSum = res.sum + gain ; 
            long newReq = res.req ; 
            if(newSum < 0){
                newReq = Math.max(newReq , -newSum);
            }
            res = new Pair(newReq , newSum);
        }

        map.put(key , res);
        return map.get(key);
    }
   

}

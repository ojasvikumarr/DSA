import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp116{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long x = Long.parseLong(st.nextToken());
            long[] arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Long.parseLong(st.nextToken());
            }
            long[] pre = new long[n];
            pre[0] = arr[0];
            for(int i = 1 ; i < n ; i++){
                pre[i] = pre[i-1] + arr[i];
            }

            int i = 0 ; 
            int j = i ; 
            long countX = 0 ; 
            while(i < n){
                j = i ; 
                while(i < n && arr[i] <= x){
                    i++ ; 
                }
                countX += solve(pre , s , j , i-1);
                while(i < n && arr[i] > x){
                    i++ ;
                }
            }
            long countY = 0 ; 
            i = 0 ; 
            j = 0 ; 
            x-- ; 
            while(i < n){
                j = i ; 
                while(i < n && arr[i] <= x){
                    i++ ; 
                }
                countY += solve(pre , s , j , i-1);
                while(i < n && arr[i] > x){
                    i++ ;
                }
            }
            long ans = countX - countY;
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    public static long solve(long[] prefix , long sum , int l , int r){
        Map<Long , Integer> map = new HashMap<>();
        long count = 0; 
        if(l > 0)
        map.put(prefix[l-1] ,1);
        else 
        map.put(0L, 1);

        for(int i = l ; i <= r ; i++){
            long diff = prefix[i] - sum ; 
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1 );
        }
        return count ; 
    }
}

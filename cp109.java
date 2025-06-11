import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp109 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());    
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            // Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Integer> idx = new HashMap<>();

            int mini = Integer.MAX_VALUE;
            int[] jump1 = new int[k+1];
            int[] jump2 = new int[k+1];

            for(int i = 1 ; i <= k ; i++){
                idx.put(i, -1);
            }

            for(int i = 0 ; i < n ; i++){
                int col = arr[i];
                if(idx.containsKey(col)){
                    int diff = i - idx.get(col) - 1 ;
                    // map.put(col, Math.max(map.getOrDefault(col, 0), diff));
                    if(diff > jump1[col]){
                        jump2[col] = jump1[col];
                        jump1[col] = diff;
                    }else if(diff > jump2[col]){
                        jump2[col] = diff;
                    }
                }
                idx.put(col, i);
            }

            for(int i = 1 ; i <= k ; i++){
                int diff = n - idx.get(i) - 1 ;
                // map.put(i, Math.max(map.getOrDefault(i, 0), diff));
                if(diff > jump1[i]){
                    jump2[i] = jump1[i];
                    jump1[i] = diff;
                }else if(diff > jump2[i]){
                    jump2[i] = diff;
                }
            }

            for(int i = 1 ; i <= k ; i++){
                mini = Math.min(mini , Math.max((jump1[i])/2 , jump2[i]));
            }
            sb.append(mini).append(" ");
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    
    public static long gcd(long a, long b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}


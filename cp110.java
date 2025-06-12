import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp110 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[][] grid = new int[n][n];

            for(int i = 0 ; i < n ; i++){
                int cnt = 0 ; 
                int ptr = i ;
                for(int j = 0 ; j < n ; j++){
                    grid[i][ptr%n] = cnt++ ;
                    ptr++ ;
                }
            }

            // for(int i = 0 ; i < n ; i++){
            //     for(int j = 0 ; j < n ; j++){
            //         sb.append(grid[i][j]);
            //         sb.append(" ");
            //     }
            //     sb.append("\n");
            // }

            // for(int i = 2 ; i <= n ; i++){
            //     if)i > 2){

            //     }
            // }
            List<String> ls = new ArrayList<>();

            for(int i = 1 ; i <= n ; i++){
                if(i > 1){
                    ls.add(i + " 1 " + (i-1));
                }
                ls.add(i + " " + (i) +" " + n);
            }
            sb.append(ls.size());
            sb.append("\n");
            for(String st : ls){
                sb.append(st);
                sb.append("\n");
            }
            // sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    
    public static long gcd(long a, long b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}


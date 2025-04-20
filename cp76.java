import java.io.InputStreamReader;
import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ;
public class cp76 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] l = new int[n];
            int[] r = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++) l[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++) r[i] = Integer.parseInt(st.nextToken());

            // List<int[]> ls = new ArrayList<>();
            // for(int i = 0 ; i < n ; i++){
            //     ls.add(new int[]{l[i] , r[i]});
            // }

            // Collections.sort(ls ,(a , b) -> b[0] + b[1] - ( a[1] + a[0]));
            long res = 0 ;
            List<Integer> rem = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                res += Math.max(l[i] ,r[i]);
                rem.add(Math.min(l[i] ,r[i]));
            }
            Collections.sort(rem);
            for(int i = rem.size()-1 ; i >= rem.size()-k+1 ; i--){
                res += rem.get(i);
            }
            res++ ; 

            // int i = 0; 
            // for(; i < k-1 ; i++){
            //     res += ls.get(i)[0] + ls.get(i)[1];
            // }
            // for(; i < n ; i++){
            //     res += Math.max(ls.get(i)[0] , ls.get(i)[1]);
            // }
            sb.append(res);
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}

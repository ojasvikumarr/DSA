import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp98 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int count = n ; 
            int res = 0 ; 
            for(int i = n-1 ; i >= 0 ; i--){
                int val = arr[i];
                int num = (int)Math.ceil((double)D/val);
                if(D == Math.ceil((double)D/val)*val){
                    num++ ;
                }
                if(count >= num){
                    count -= num ;
                    res++ ;
                }else{
                    break ;
                }
            }
            sb.append(res);
            sb.append("\n");
        // }
        System.out.println(sb.toString());
        br.close();
    }
}

import java.util.* ; 
import java.lang.StringBuilder ; 
import java.io.* ; 
import java.util.Arrays ;

public class cp61 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(solve(arr, n)+"\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    public static int solve(int[] arr ,int n){
        Arrays.sort(arr);
        int diff = arr[n-1] - arr[0];
        return diff ; 
    }
}

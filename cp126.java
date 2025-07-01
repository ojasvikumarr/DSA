import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp126{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[] freq = new int[n+1];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] <= n) freq[arr[i]]++;
            }
            int[] res = new int[n+1];
            res[0] = 1; 
            for(int i = 1 ; i <= n ; i++){
                freq[i] += freq[i-1];
            }
            for(int i)
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
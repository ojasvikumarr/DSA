import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ; 

public class cp99 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            Map<Integer , Integer> map = new HashMap<>();
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i] , i);
                temp[i] = arr[i];
            }
            Arrays.sort(arr);
            long[] preSum = new long[n];
            preSum[0] = arr[0];
            for(int i = 1 ; i < n ; i++){
                preSum[i] = preSum[i-1] + (long)arr[i];
            }

            int[] res = new int[n];
            res[n-1] = n-1; 
            Map<Integer, Integer> mp = new HashMap<>();
            mp.put(arr[n-1] , n-1);
            for(int i = n-2 ; i >= 0 ; i--){
                if(preSum[i] >= arr[i+1]){
                    res[i] = res[i+1];
                }else{
                    res[i] = i ;
                }
                mp.put(arr[i] , res[i]);
            }

            int[] ans = new int[n];
            for(int i = 0 ; i < n; i++){
                ans[i] = mp.get(temp[i]);
            }
            for(int ele : ans){
                sb.append(ele + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp94 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            Map<Integer , Integer> map = new HashMap<>();

            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                map.put(arr[i] , map.getOrDefault(arr[i], 0)+1);
            }

            int mini = Integer.MAX_VALUE ;
            for(int i = 0 ; i < n ; i++){
                for(int j = i+1 ; j < n ; j++){
                    mini = Math.min(mini , gcd(arr[i] , arr[j]));
                }
            }
            if(map.containsKey(mini)){
                sb.append(n-map.get(mini));
            }else{
                
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int gcd(int a , int b){
        if(a == 0) return b ;
        return gcd(b%a , a);
    }
}

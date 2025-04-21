import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp81 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k =Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            List<Integer> small = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i] <= k) small.add(arr[i]);
            }

            if(small.size() == n){
                //that is all are small 
                sb.append("YES \n");
                continue ; 
            }
            boolean flag = false ;
            for(int i = 0 ; i < small.size() ; i++){
                for(int j = i+1 ; j < small.size() ; j++){
                    if(Math.abs(small.get(i) - small.get(j)) > 1){
                        flag = true ;
                        break ;
                    }
                }
                if(flag== true){
                    break ;
                }
            }
            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb); 
    }
}

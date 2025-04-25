import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp82 {
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

            long[] a = new long[n];
            long[] b = new long[n];
            Long maxi = 0L ; 
            Long mini = Long.MAX_VALUE ;
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                a[i] = Long.parseLong(st.nextToken());
                maxi = Math.max(maxi , a[i]);
                mini = Math.min(mini , a[i]);
            }
            st = new StringTokenizer(br.readLine());
            boolean allNeg = true ;
            for(int i = 0 ; i < n ; i++){
               b[i] = Long.parseLong(st.nextToken());
               if(b[i] != -1) allNeg = false ;
            }

            if(allNeg == true){
                //jo max eleme hai vo 
                sb.append(k-maxi+mini+1);
            }else{
                //we need to check whther we can make one 
                long sum = 0 ; 
                for(int i = 0 ; i < n ; i++){
                    if(b[i] != -1){
                        sum = (b[i] + a[i]);
                    }
                }

                boolean flag = true ; 
                for(int i = 0 ; i < n ; i++){
                    if(b[i] != -1){
                        if(b[i] + a[i] != sum){
                            flag = false ;
                            break ; 
                        }
                    }
                }

                if(flag == false || sum < maxi || (sum-mini) > k){
                    sb.append(0);
                }else{
                    sb.append(1);
                }
            }

            sb.append("\n");
        }
        System.out.println(sb); 
    }
}

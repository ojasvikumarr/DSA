import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ; 
public class cp88 {
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

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int longest = 0 ; 
            int[] diff = new int[n-1];

            for(int i = 1 ; i < n ;i++){
                diff[i-1] = Math.abs(arr[i] - arr[i-1]);
            }

            int maxi = Integer.MIN_VALUE ; 
            for(int i = 0 ; i < n-1 ; i++){
                // System.out.print(diff[i] + " ");
                if(diff[i] <= k){
                    longest++ ; 
                }else{
                    maxi = Math.max(maxi , longest);
                    longest = 0 ;
                }
            }
            maxi = Math.max(maxi , longest);
            // System.out.println(maxi + " --");
            if(maxi == Integer.MIN_VALUE) maxi = 0 ; 
            sb.append(n-maxi-1);
            sb.append("\n");

        }
        System.out.println(sb.toString());
   }

}



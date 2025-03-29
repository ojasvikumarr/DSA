package CodeForces;
import java.util.* ; 
public class subseqAddition {
    
        // 327 ms	1600 KB
        // public static void main(String[] args) throws IOException{
        //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //     StringBuilder sb = new StringBuilder();
        //     int t = Integer.parseInt(br.readLine());
        //     while(t-- > 0){
        //         int n = Integer.parseInt(br.readLine());
        //         int[] arr = new int[n];
        //         StringTokenizer st = new StringTokenizer(br.readLine());
        //         for(int i = 0 ; i < n ; i++){
        //             arr[i] = Integer.parseInt(st.nextToken());
        //         }
        //         if(solve(arr, n)){
        //             sb.append("YES");
        //         }else{
        //             sb.append("NO");
        //         }
        //         sb.append("\n");
        //     }
        //     System.out.println(sb.toString());
        // }
        // 593 ms	1500 KB
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int t =sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int[] arr = new int[n];
                for(int i = 0 ; i < n ; i++){
                    arr[i] = sc.nextInt();
                }
                if(solve(arr, n)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
            sc.close();
        }
        public static boolean solve(int[] arr ,int n){
            Arrays.sort(arr);
            long preSum = arr[0] ; 
            if(preSum != 1) return false ;
            for(int i = 1 ; i < n ; i++){
                if(preSum < arr[i]){
                    return false ; 
                }
                preSum += arr[i];
            }
            return true ; 
        }
    }
    


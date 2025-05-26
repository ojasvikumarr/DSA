import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp86 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for(int i = 0 ;i < n ; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> res = new ArrayList<>();
            res.add(b[0]);
            for(int i = 1 ; i < n ; i++){
                if(res.get(res.size() - 1) > b[i]){
                    res.add(1);
                }
                res.add(b[i]);
            }
            sb.append(res.size() + "\n");
            for(int ele : res){
                sb.append(ele + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
   }
}



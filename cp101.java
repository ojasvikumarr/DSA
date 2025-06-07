import java.io.* ; 
import java.lang.StringBuilder; 
import java.util.* ; 

public class cp101 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            boolean flag = true ;
            for(int i = 0 ; i < n ; i++){
                arr[i] = (((l-1)/(i + 1))+ 1)*(i+1) ; 
                if(arr[i] > r){
                    flag = false ;
                    break ; 
                } 
            }
            if(flag == false){
                sb.append("No");

            }else{
                sb.append("Yes");
                sb.append("\n");
                for(int ele : arr){
                    sb.append(ele + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

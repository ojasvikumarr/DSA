import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder; 
class Codechef {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i =0  ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                arr[i] %= 3 ; 
            }
            int one = 0 ; 
            int two = 0 ; 

            boolean flag = false ; 
            for(int i = 0 ; i < n; i++){
                if(arr[i] == 0){
                    flag = true ; 
                    break ; 
                }else if(arr[i] == 1){
                    if(two > 0){
                        flag = true ; 
                        break ;
                    }else{
                        one++ ;
                    }
                }else if(arr[i] == 2){
                    if(one > 0){
                        flag = true ; 
                        break ; 
                    }else{
                        two++ ;
                    }
                }else if(one >= 3 || two >= 3){
                    flag = true ; 
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
        System.out.println(sb.toString());
    }
}

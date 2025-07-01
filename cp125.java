import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp125{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String s = br.readLine();
            int ones = 0 ; 
            for(char c : s.toCharArray()){
                if(c == '1')ones++ ; 
            }
            if(k >= ones){
                sb.append("Alice");
            }else if((n%2 == 0 && k >= (n/2)) || (n%2 != 0 && k > (n+1)/2)){
                sb.append("Alice");
            }else if((n%2 == 1 && s.charAt(n/2) == '1' && k == (n+1)/2)){
                sb.append("Alice");
            }else{
                sb.append("Bob");
            }
            // sb.append((5/2));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
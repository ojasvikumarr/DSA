import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp91 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());


            int newA = b + ( b - c );
            int newB = a + (c - a)/2 ;
            int newC = b + ( b - a );
            if(newA != 0 && newA > a && newA%a == 0){
                sb.append("YES");
            }else if(newB != 0 && newB > b && newB%b == 0 && (c-a) % 2 == 0){
                sb.append("YES");
            }else if(newC >= c && newC%c == 0 && newC != 0){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

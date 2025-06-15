import java.util.* ; 
import java.lang.* ; 
import java.io.* ; 

public class cp111{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int c1 = x1 + a ; 
            int d1 = y1 + b ; 

            int c2 = x2 + a ; 
            int d2 = y2 + b ; 

            int dist1 = Math.max(0 , (x2-c1));
            int dist2 = Math.max(0 , (y2-d1));
            int dist3 = Math.max(0 , (c2-x1));
            int dist4 = Math.max(0 , (d2-y1));
            if(c1 < x2 && (x2-c1)%a == 0){
                sb.append("Yes");
            }else if(d1 < y2 && (y2-d1)%b == 0){
                    sb.append("Yes");
            }else if(c2 < x1 && (x1-c2)%a == 0){
                    sb.append("Yes");
            }else if(d2 < y1 && (y1-d2)%b == 0){
                sb.append("Yes");
            }else{
                if(dist1 == 0 && dist2 ==0 || dist3 == 0 && dist4 == 0){
                    sb.append("Yes");
                }else{
                sb.append("No");

                }
            }
            
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
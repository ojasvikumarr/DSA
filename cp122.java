import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp122{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long res = 0 ; 
            int[][] balls = new int[n][4];
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine());
                int dx = Integer.parseInt(st.nextToken());
                int dy = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                balls[i][0] = dx;
                balls[i][1] = dy;
                balls[i][2] = x;
                balls[i][3] = y;

            }

            for(int i = 0 ; i < n ; i++){
                int dx = balls[i][0];
                int dy = balls[i][1];
                int x = balls[i][2];
                int y = balls[i][3];
                long tx1 = Long.MAX_VALUE;
                if(dx < 0){
                    tx1 = (long)x ;
                }
                long tx2 = Long.MAX_VALUE;
                if(dx >0){
                    tx2 = (s-x) ; 
                }
                long ty1 =Long.MAX_VALUE;
                if(dy < 0){
                    ty1 = (long)y ;
                }
                long ty2 = Long.MAX_VALUE; 
                if(dy > 0){
                    ty2 = (s-y) ;
                }

                long ans = Long.MAX_VALUE ; 
                long[] timeTaken = {tx1 , tx2 , ty1 , ty2};
                for(int j = 0 ; j < 4 ; j++){
                        ans = Math.min(ans , Math.max(0 , timeTaken[j]));
                }

                long X = x + dx*ans ; 
                long Y = y + dy*ans ; 
                if((X == 0 && Y == s) || 
                    (X == 0 && Y == 0) || 
                    (Y == 0 && X == s) || 
                    (Y == s && X == s) ){
                        res++ ;
                    }

            }
            sb.append(res);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
import java.util.*;
import java.lang.StringBuilder;
import java.io.*;

class CodeChef
{
	public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
            int E = n * (n - 1) / 2;
            int minW = Math.max(0, n - 1 - (E - m));
            int maxW = Math.min(m, n - 1);
            if (minW > maxW) {
				sb.append(0);
            } else {
                // Sum of all integers from minW to maxW
                int count = maxW - minW + 1;
                int sum = (minW + maxW) * count / 2;
				sb.append(sum);
            }
			sb.append("\n");
        }
        System.out.println(sb); 
    }
}

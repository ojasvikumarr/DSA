package PlacementTime.CSES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RemovingDigits {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // bw.write("Hello");
        bw.write(recur(n) + " ");
        br.close();
        bw.close();
    }

    public static int recur(int n){
 
        if(n == 0){
            return 0 ; 
        }

        String str = String.valueOf(n);
            int maxi = 0 ; 
            for(char c : str.toCharArray()){
                maxi = Math.max(maxi , c - '0');
            }

            n -= maxi ;
            return 1 + recur(n);
    }
    public static int solve(int n){
        int operations = 0 ;
        // System.out.println("Hello");
        while(n != 0 ){
            String str = String.valueOf(n);
            int maxi = 0 ; 
            for(char c : str.toCharArray()){
                maxi = Math.max(maxi , c - '0');
            }
            operations++ ; 
            n -= maxi ;
            // System.out.println(n);
        }
        return operations ;
    }
}

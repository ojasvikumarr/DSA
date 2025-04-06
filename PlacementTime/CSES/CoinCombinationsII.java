package PlacementTime.CSES;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinCombinationsII {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int MOD = (int)1e9 + 7 ; 
        // int[][] dp = new int[n+1][sum+1] ;
        int[] prev = new int[sum+1];
        int[] curr = new int[sum+1];
        prev[0] = 1; 


        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j <= sum ; j++){
                int skip = prev[j];
                int pick = 0 ; 
                if(arr[i] <= j){
                    pick = prev[j-arr[i]];
                }
                curr[j] =( skip + pick )%MOD; 
            }
            prev = Arrays.copyOf(curr , sum+1);
        } 

        bw.write(prev[sum] + " \n");
        br.close();
        bw.close();
    }
}

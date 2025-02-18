package DynamicProgramming;

public class DominoTronimo {
    class Solution {
        int MOD = (int)1e9 + 7 ; 
        public int numTilings(int n) {
            int[] full = new int[n+1];
            int[] topMiss = new int[n+1];
            int[] bottomMiss = new int[n+1];
            full[0] = 1 ; 
            full[1] = 1 ; 
            topMiss[0] = 0 ; 
            bottomMiss[0] = 0 ; 
            for(int i = 2 ; i <= n ; i++){
                full[i] = ((full[i-1] + full[i-2])%MOD + (topMiss[i-1] + bottomMiss[i-1])%MOD)%MOD;
                topMiss[i] = (full[i-2] + bottomMiss[i-1])%MOD;
                bottomMiss[i] = (full[i-2] + topMiss[i-1])%MOD;
            }
            return full[n]%MOD;
        }
    }
}

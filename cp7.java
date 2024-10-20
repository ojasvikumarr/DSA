import java.util.*;

public class cp7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int x = sc.nextInt(); 
            int y = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(helper1(x , y , k));
        }

        sc.close();
    }
    public static int helper(int x , int y , int k){
        int xx = 0 ; 
        int yy = 0 ; 
        boolean freqofLeftag = true ;
        int steps = 0 ; 
        while(xx < x || yy < y){
            if(freqofLeftag){
                if(xx < x){
                    xx = Math.min(x, xx + k);
                }
            } else {
                if(yy < y){
                    yy = Math.min(y, yy + k);
                }
            }
            freqofLeftag = !freqofLeftag; 
            steps++;
        }
        return steps ;
    }
    public static int helper1(int x , int y , int k){
        int mini = Math.min(x , y);
        int movie = mini/k ;
        if(mini%k != 0){
            movie++ ;
        }
        x -= movie*k ;
        y -= movie*k ;
        int ans = movie ;
        if(x == 0){
            ans += y/k ;
            if(y%k != 0){
                ans ++ ;
            }
        }else{
            ans += x/k ;
            if(x%k != 0){
                ans++ ;
            }
        }
        return ans ;
    }


    public static int helper(int n, int[] a) {
        int c = 0;
        int[] freqofLeft = new int[201];
        int[] fr = new int[201];

        for (int i = 0; i < n; i++) {
            fr[a[i]]++;
        }

        for (int j = 0; j < n; j++) {
            fr[a[j]]--;
            for (int i = 1; i <= 100; i++) {
                if (freqofLeft[i] > 0) {
                    int rk1 = i + (a[j] - i);
                    int rk2 = i - (a[j] - i);
                    if (rk1 >= 1 && rk1 <= 100) {
                        c += fr[rk1] * freqofLeft[i];
                    }
                    if (rk2 >= 1 && rk2 <= 100) {
                        c += fr[rk2] * freqofLeft[i];
                    }
                }
            }
            freqofLeft[a[j]]++;
        }

        return c;
    }
    public static long helper(int n, int X, int[] B) {
        long[] C = new long[n];
        C[0] = B[0];
        long ans = Math.abs(C[0] - B[0]);
        for (int i = 1; i < n; i++) {
            long minii = Math.max(C[i - 1], B[i] - X);
            C[i] = minii; 
            long maxi = Math.min(C[i - 1] + X, B[i] + X);
            if (C[i] > maxi) {
                C[i] = maxi;
            }
            ans = Math.max( Math.abs(C[i] - B[i]),ans);
        }

        return ans;
    }
}

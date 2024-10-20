import java.util.Scanner;

public class ImportantInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // number of integers on the board
        for(int i = 0  ; i < t ; i++){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int j = 0 ; j < n ; j++){
                arr[j] = sc.nextInt();
            }
            String s = sc.next();
            System.out.println(maxCount(n , arr , s));
        }
        sc.close();
    }
    private static int maxCount(int n, int[] arr , String str){
        int l = 0 ; 
        int r = n-1 ; 
        int ans = 0 ;
        while(l < r){
            while(str.charAt(l) != 'L') l++ ;
            while(str.charAt(r) != 'R') r-- ;
            for(int i = l ; i <= r ; i++){
                ans += arr[i];
            }
            l++ ;
            r-- ;
        }
        return ans ;
    }
}

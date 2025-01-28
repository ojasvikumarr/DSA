package AtCoders;

import java.util.* ; 

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() ;
        int[] arr = new int[n];
        
        for(int i = 0 ; i < n ; i++){ 
            arr[i] = sc.nextInt();
        }
        if(solveII(arr , n)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        // System.out.println(solve(arr));
        sc.close();
    }

    public static boolean solveII(int[] arr , int n){
        if(n <= 2) return true ; 

        // double ratio = (double)(arr[1]/arr[0]);
        int Gcd = gcd(arr[1] , arr[0]);

        String ratio = String.valueOf(arr[1]/Gcd + "-" + arr[0]/Gcd);

        for(int i = 0 ;i < n-1 ; i++){
            int GCd = gcd(arr[i+1] , arr[i]);
            String ratioI = String.valueOf(arr[i+1]/GCd + "-" + arr[i]/GCd);
            if(!ratio.equals(ratioI)){
                return false ;
            }
        }
        return true ; 
    }
    public static int gcd(int a , int b){
        while(a!=0){
            int temp = a ; 
            a = b % a ;
            b = temp ; 
        }
        return b ; 
    }
    public static boolean solve(int[] arr){
        int count = 0 ; 
        for(int j = 0 ; j < 4 ; j++){
            for(int i = 0 ; i < 4 ; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp ;
                    count++ ;
                }
            }
        }
        return count == 1 ? true : false ; 
    }
}

package AtCoders;

import java.util.* ; 

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = 5 ;
        int[] arr = new int[n];
        for(int i =0 ; i < n ; i++) arr[i] = sc.nextInt();

        if(solve(arr)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        // System.out.println(solve(arr));
        sc.close();
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

import java.util.* ; 
public class cp64 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            System.out.println(solve(arr , n));
        }
        sc.close();
    }
    public static int solve(int[] arr , int n){
        // pointer 
        int i = n-2 ; 
        int counter = 1 ; 
        int operations = 0 ; 
        boolean f = true ;
        for(int k = 0 ; k < n-1 ; k++){
            if(arr[k] != arr[k+1]) f = false ;
        }
        if(f == true) return 0 ; 
        while(i >= 0){
            //while loop 
            operations++ ;
            for(int j = 0 ; j < counter && i >= 0; j++){
                arr[i] = arr[i+1];
                i-- ;
            }
            counter = counter * 2 ;
            //i need to check the aray has it become good 
            int j = i ; 
            boolean flag = true ;
            while(j >= 0){
                if(arr[j] != arr[j+1]){
                    flag = false ;
                    break ; 
                }
                j--; 
            }
            if(flag == true) break ; 
        }
        return operations ; 
    }
}

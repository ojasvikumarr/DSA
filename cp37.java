import java.util.* ; 

public class cp37 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int mini = Integer.MAX_VALUE ; 
            for(int i =0  ; i < n ; i++) {
                arr[i] = sc.nextInt();
                mini = Math.min(mini , arr[i]);
            }
        
            if(arr[0] == mini){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }

}

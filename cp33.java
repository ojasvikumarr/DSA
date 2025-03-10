import java.util.* ; 

public class cp33 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            boolean isSorted = true ; 
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
                if(i > 0){
                    if(arr[i] < arr[i-1]) isSorted = false ;
                }
            }
            if(isSorted || k >= 2){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }

}

import java.util.*; 
public class cp75 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int ele = 1<<((int)Math.floor(Math.log(n)/Math.log(2)));
            for(int i = 1 ; i < n ; i++){
                if(i == ele){
                    System.out.print("0 ");
                }
                System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}
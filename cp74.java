import java.util.* ; 
public class cp74 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--  >0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int xor = 0 ; 
            for(int i = 0 ; i < a ; i++){
                xor ^= i ; 
            }
            if(xor == 0 && b < a){
                System.out.println(a+2);
            }else 
        }
        sc.close();
    }

   
}

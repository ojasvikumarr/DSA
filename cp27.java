import java.util.* ; 
public class cp27 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(solve(x , y)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static boolean solve(int x , int y){
        if( x > y && (x-y+1)%9 == 0){
            return true ; 
        }
        else if((x % 9) == 0 && y == 1){
            return true; 
        }else if((x - y) == 8){
            return true ;
        }else if((y - x) == 1){
            return true ; 
        }
        return false ;
    }
}

import java.util.Scanner;

public class cp70 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0 ){
        int n = sc.nextInt();
        String s = sc.next();

        int mini = Integer.MAX_VALUE ; 
        int val = 0 ; 
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c == ')'){
                val-- ; 
            }else{
                val++ ; 
            }
            mini = Math.min(mini , val);
        }
        System.out.println(Math.abs(mini));
    }
    sc.close();
   }
}

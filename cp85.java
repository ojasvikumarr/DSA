import java.util.Scanner;
import java.lang.StringBuilder;

public class cp85 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int counter = 0 ; 
            for(int i = 0 ; i < 10 ; i++){
                int cnt = 0 ; 
                for(int j = 0 ; j < 10; j++){
                    if(j < 5 && cnt < counter ){
                        cnt++ ; 
                    }else if(j >= 5 && cnt >= counter){
                        cnt-- ;
                    }
                    char c = sc.next().charAt(0);
                    if(c == 'X'){

                    }
                }
                if(i < 5) counter++ ;
                else counter-- ; 
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}

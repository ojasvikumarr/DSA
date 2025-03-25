import java.util.Scanner;
import java.util.Arrays ;
import java.util.* ; 
public class cp55 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            List<Integer> ls = new ArrayList<>();
            int globalMini = Integer.MAX_VALUE ;
            for(int i = 0 ; i < n ; i++){
                int sec = Integer.MAX_VALUE ; 
                int fir = Integer.MAX_VALUE ; 
                //no input of ls 
                int m = sc.nextInt();
                for(int j = 0 ; j < m ; j++){
                    int val = sc.nextInt();
                    if(fir >= val){
                        sec = fir ; 
                        fir = val ; 
                    }else if(sec > val){
                        sec = val ; 
                    }
                }
                globalMini = Math.min(globalMini, fir) ;
                ls.add(sec);
            }
            Collections.sort(ls);
            long ans = (long)globalMini ; 
            for(int i = 1 ; i < ls.size() ; i++) ans += (long)ls.get(i);
            System.out.println(ans);
        }
        sc.close();
    }
    
}

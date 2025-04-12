import java.util.* ; 
import java.lang.StringBuilder ;

public class Main {
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int o = 0 ; 
            int q = 0 ; 
            StringBuilder sb = new StringBuilder(s);



            if(n >=2 && sb.charAt(0) == '?' && sb.charAt(1) == 'o'){
                sb.setCharAt(0, '.');
            } 
            if(n > 1 && sb.charAt(n-1) == '?' && sb.charAt(n-2) == 'o'){
                sb.setCharAt(n-1, '.');
            }
            for(int i = 0 ; i < n ; i++){
                if(sb.charAt(i) == '?' && i > 0 && i < n-1){
                    if(sb.charAt(i-1) == 'o' || sb.charAt(i+1) == 'o'){
                        //this will be a dot 
                        sb.setCharAt(i , '.');
                        continue ; 
                    }
                }
                if(sb.charAt(i) == '?'){
                    q++ ;
                }
                if(sb.charAt(i) == 'o'){
                    o++ ;
                }
            }

            // System.out.println(o+"--");


            if(q <= k - o){
                //we dont have any option 
                for(int i = 0 ; i < n ; i++){
                    if(sb.charAt(i) == '?'){
                        sb.setCharAt(i, 'o');
                    }
                }
            }else if(k == o){
                for(int i = 0 ; i < n ; i++){
                    if(sb.charAt(i) == '?'){
                        sb.setCharAt(i, '.');
                    }
                }
            }
            System.out.println(sb.toString());
            sc.close();
        }
        
    }
   

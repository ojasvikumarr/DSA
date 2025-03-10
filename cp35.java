import java.util.* ; 

public class cp35 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int blanks = 0 ; 
            int cons = 0 ; 
            boolean flag = false ; 
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                if(c == '.'){
                    blanks++ ; 
                    cons++  ;
                }else{
                    cons = 0 ; 
                }
                if(cons == 3){
                    flag = true ; 
                }
            }
            if(flag == true){
                System.out.println(2);
            }else{
                System.out.println(blanks);
            }
        }
        sc.close();
    }

}

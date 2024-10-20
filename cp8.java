import java.util.* ;
public class cp8 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        for(int tc = 0 ; tc < tt ; tc++){
            String s = sc.next();
            String t = sc.next();
            if(s.length() > t.length()){
                System.out.println(helper(s , t));
            }else{
                System.out.println(helper(t , s));
            }
        }
    }

    
    public static int helper(String s , String t){

        //case 1 edges pe hai vo string 
        int i = 0 ;
        while(i < t.length()){
            if(s.charAt(i) != t.charAt(i)){
                break; 
            }
            i++ ;
        }
        if(i == t.length()){
            return s.length() + 1 ; 
        }
        if(i != t.length() && i != 0 ){
            return s.length() + t.length() - i + 1;
        }
        else{
            return s.length() + t.length();
        }
    }
}

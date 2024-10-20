
import java.util.* ;

public class StringConversion {
    public static void main(String[] argv){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(helper(str));
        sc.close();
    }
    // public static String helper(String str){
    //     return str
    //     .replace(/([A-Z])/g , '\n$1')
    //     .split('\n')
    //     .map((part , index) => 
    //     index === 0 ? part.toUpperCase() : part.charAt(0).toLowerCase() + part.slice(1).toUpperCase())
    //     .join('\n');
    // }
    public static String helper(String str){
        StringBuilder s = new StringBuilder("");

        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                s.append('\n');
                s.append(Character.toLowerCase(c));
            }else{
                s.append(Character.toUpperCase(c));
            }
        }
        return s.toString();

    }
}

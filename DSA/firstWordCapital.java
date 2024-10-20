import java.io.IOException;

public class firstWordCapital {
    public static String toUpperCase(String str) throws IOException{
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        ((Appendable) sb).append(ch);

        for(int i = 0 ; i<((CharSequence) sb).length();i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));    
        }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    
    }
    public static void main (String args[]) throws IOException{
        String a = "my name is ojasvi kUMAR!!!";
        System.out.println(toUpperCase(a));
    }
}
import java.io.* ; 
import java.util.* ; 
import java.lang.StringBuilder ; 

public class cp93 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            String s = br.readLine();
            int n = s.length();
            int ab = 0 ; 
            int ba = 0 ; 

            for(int i = 1 ; i < n ; i++){
                char a = s.charAt(i-1);
                char b = s.charAt(i);
                if(a == 'b' && b == 'a'){
                    ba++ ;
                }else if(a == 'a' && b == 'b'){
                    ab++ ;
                }
            }

            if(ab == ba){
                sb.append(s);
            }else{
                StringBuilder res = new StringBuilder(s);
                if(s.charAt(n-1) == 'a'){
                    res.setCharAt(n-1 , 'b');
                }else{
                    res.setCharAt(n-1 , 'a');
                }
                sb.append(res);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}

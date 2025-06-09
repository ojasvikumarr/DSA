import java.util.* ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.StringBuilder ;
import java.io.* ; 
import java.util.Arrays ; 

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int i = 0 ; 
            StringBuilder st = new StringBuilder();
            while(i < n-1 && s.charAt(i) <= s.charAt(i+1)){
                st.append(s.charAt(i));
                i++ ; 
            }
            int j = i ; 
            i++ ; 
            while(i < n && s.charAt(i) <= s.charAt(j)){
                st.append(s.charAt(i));
                i++ ; 
            }
            st.append(s.charAt(j));
            while(i < n){
                st.append(s.charAt(i));
                i++ ; 
            }
            sb.append(st.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }        
        
}
   

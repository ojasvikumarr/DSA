import java.lang.StringBuilder ; 
import java.util.* ; 
import java.io.* ; 

public class cp60 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String s = br.readLine();
            sb.append(solve(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static long solve(String s){
        //we need to get the largest window 
        long maxi = 0 ; 
        int i = 0 ; 
        int rotates = 0 ; 
        while( i < s.length()*2 && rotates < 2){
            if(s.charAt(i%s.length()) == '1'){
                long counter = 0 ; 
                // System.out.println("YEs");
                while(i < s.length()*2 && s.charAt(i%s.length()) == '1'){
                    counter++ ; 
                    i++ ; 
                }
                // System.out.println(counter);
                maxi = Math.max(maxi , counter);
            }else{
                i++ ; 
            }
            if(i == (s.length()-1)) rotates++ ; 
        }
        long res = 0 ; 
        if(maxi == 1){
            return 1 ;
        }
        else if(maxi % 2 == 0){
            //even 
            res = (maxi/2)*(maxi/2);
        }else{
            res = ((maxi/2) + 1)*(maxi/2);
        }
        // System.out.println(res);
        return res ;
    }
}

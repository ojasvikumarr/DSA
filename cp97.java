import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp97 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int[] preMax = new int[n];
            int[] sufMax = new int[n];
            Set<Character> set = new HashSet<>();
            for(int i = 0 ; i < n ; i++){
                set.add(s.charAt(i));
                preMax[i] = set.size();
            }
            set.clear();
            for(int i = n-1 ; i >= 0 ; i--){
                set.add(s.charAt(i));
                sufMax[i] = set.size();
            }
            int maxi = 0 ; 
            for(int i = 1 ; i < n ; i++){
                maxi = Math.max(maxi , preMax[i-1] + sufMax[i]);
            }
            sb.append(maxi);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}

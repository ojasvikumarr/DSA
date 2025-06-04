import java.util.* ; 
import java.io.* ; 
import java.lang.StringBuilder ; 

public class cp97 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            String s = br.readLine();
            List<Integer> indices = new ArrayList<>();
            List<Integer> start = new ArrayList<>();

            for(int i = 0; i < n; i++){
                if(s.charAt(i) == 'g'){
                    indices.add(i);
                }else if(s.charAt(i) == c){
                    start.add(i);
                }
            }


            int maxi = 0 ; 
            for(int ele : start){
                int index = solve(ele , indices);
                int val = indices.get(index);
                if(val < ele ){
                    maxi = Math.max(maxi , n - ele + indices.get(0));
                }else{
                    maxi = Math.max(maxi , val - ele);
                }
            }
            sb.append(maxi);
            sb.append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
    public static int solve(int i ,List<Integer> indices){
        int l = 0 ;
        int r = indices.size()-1;
        while(l < r){
            // int mid = r + (l - r)/2 ; 
            int mid = (r + l)/2 ;
            if(indices.get(mid) >= i){
                r = mid ; 
            }else{
                l = mid + 1; 
            }
        }
        return r ; 
    }
}

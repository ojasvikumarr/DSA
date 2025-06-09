import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp103 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for(int i = 0 ; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] b = new int[n];
            for(int i = 0 ; i < n; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            Map<Integer, List<Integer>> mapA = new HashMap<>();
            Map<Integer, List<Integer>> mapB = new HashMap<>();
            int maxi = 0 ; 
            for(int i = n-1 ; i >= 0 ; i--){
                if(mapA.containsKey(a[i])){
                    maxi = Math.max(maxi , i+1);
                    break ;
                }else if(mapB.containsKey(b[i])){
                    maxi = Math.max(maxi , i+1);
                    break ; 
                }
                mapA.putIfAbsent(a[i], new ArrayList<>());
                mapB.putIfAbsent(b[i], new ArrayList<>());
                mapA.get(a[i]).add(i);
                mapB.get(b[i]).add(i);
                // mapA.put(a[i] , i);
                // mapB.put(b[i] , i);
                if(a[i] == b[i]){
                    maxi = Math.max(maxi , i+1);
                    break ; 
                }
                if(mapA.containsKey(b[i])){
                    //i need to traverse over all idex
                    for(int idx : mapA.get(b[i])){
                        int diff = idx - i ; 
                    if(diff != 1){
                        maxi = Math.max(maxi , i+1);
                        break ; 
                    }
                    }
                }
                if(mapB.containsKey(a[i])){
                    for(int idx : mapB.get(a[i])){
                        int diff = idx - i ; 
                        if(diff != 1){
                            maxi = Math.max(maxi , i+1);
                            break ; 
                        }
                    }
                }
            }
            sb.append(maxi);
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
    public static int gcd(int a , int b){
        if(b == 0) return a ; 
        return gcd(b , a%b);
    }
}


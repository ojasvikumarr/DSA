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
        // int tc = Integer.parseInt(br.readLine());
        // while(tc-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 1 ;i < n; i++){
                arr[i] = (Integer.parseInt(st.nextToken()) + arr[i-1])%l;
            }
            for(int i = 0 ; i < n; i++){
                arr[i] = arr[i]%l ;
            }
            Map<Integer , List<Integer>> map = new HashMap<>();
            for(int i = 0 ; i < n ; i++){
                int ele = arr[i];
                // map.put(ele , map.getOrDefault(ele , 0)+1);
                map.putIfAbsent(ele , new ArrayList<>());
                map.get(ele).add(i);
            }
            int dist = l/3 ; 
            long res = 0 ; 
            if(l % 3 != 0){
                sb.append(0);
                sb.append("\n");
                System.out.println(sb.toString());
                return ; 
            }
            // Set<Integer> set = new HashSet<>();
            for(int key : map.keySet()){
                int left = (key + dist )%l ; 
                int right = (left + dist)%l ;
                // if(map.containsKey(left) && map.containsKey(right) && !set.contains(left) && !set.contains(right)){
                //     res += (long)map.get(key)*(long)map.get(left)*(long)map.get(right);
                //     set.add(left);
                //     set.add(right);
                // }
                if(left < key || right < key) continue ;
                if(map.containsKey(left) && map.containsKey(right)){
                    for(int ele : map.get(key)){
                        for(int elee : map.get(left)){
                            if(ele < elee){
                                for(int eleee : map.get(right)){
                                    if(elee < eleee){
                                        res++  ;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sb.append(res);
            sb.append("\n");
        // }
        System.out.println(sb.toString());

        br.close();
    }        
        
}
   

import java.util.* ; 
public class cp28 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n; i++) arr[i] = sc.nextInt();

            if(solveII(arr , n)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static boolean solveII(int[] arr , int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer it : arr) pq.add(it);
        while(!pq.isEmpty()){
            int prev = -1 ; 
            int first = pq.poll();
            if(pq.isEmpty()) return false ;
            int second = pq.poll();
            if(first != second) return false  ;
            prev = first ; 
            //Now we pop everyone 
            while(!pq.isEmpty() && pq.peek() == prev){
                int val = pq.poll();
                pq.offer(val+1);
            }
        }
        return true ;
    }
    public static boolean solve(int[] arr , int n){
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(Integer it : arr){
            map.put(it , map.getOrDefault(it, 0)+1);
        }
        //Now we traverse the map 
        int count = 0 ; 
        int prevKey = -1 ; 
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(prevKey != -1 && key != prevKey+1){
                if(count % 2 != 0) return false ;
                count = 0 ; 
            }
            if(freq > 2){
                count += (freq - 2) ;
                map.put(key , 2);
            }else if(freq % 2 == 1){
                if(count <= 0) return false ;
                count-- ; 
                map.put(key , freq+1);
            }
            prevKey = key ; 
        }
        return count % 2 == 0 ; 
    }
}

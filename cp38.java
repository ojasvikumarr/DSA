import java.util.* ; 

public class cp38 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            Map<Integer , Integer> map = new HashMap<>();
            for(int i =0  ; i < n ; i++) {
                arr[i] = sc.nextInt();
                map.put(arr[i] , map.getOrDefault(arr[i] , 0)+1);
            }
            boolean flag = false ;
            if(map.size() == 2){
                int freq1 = 0 ; 
                int freq2 = 0 ; 
                for(Integer key : map.keySet()){
                    if(freq1 == 0 )freq1 = map.get(key);
                    else freq2 = map.get(key);
                }
                if(Math.abs(freq1 - freq2) <= 1){
                    flag = true ; 
                }
            }
            if(flag || map.size() == 1){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }

}

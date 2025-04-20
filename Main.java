import java.util.* ; 
import java.lang.StringBuilder ;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < l ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int val = (a+b)%n ; 
            map.put(val , map.getOrDefault(val , 0)+1);
        }

        long res = ((long)l*(l-1))/2 ;
        for(Integer key : map.keySet()){
            int f = map.get(key);
            res -= (f*(f-1))/2 ;
        }
        System.out.println(res);
        sc.close();
    }        
        
}
   


// Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         int[] dishes = new int[m];
//         List<List<Integer>> edges = new ArrayList<>(); 
//         for(int i = 0 ; i < n ; i++){
//             edges.add(new ArrayList<>());
//         }
//         for(int i = 0 ; i < m ; i++){
//             int k = sc.nextInt();
//             dishes[i] += k ; 
//             for(int j = 0 ; j < k ; j++){
//                 int x = sc.nextInt() - 1;
//                 edges.get(x).add(i);
//             }
//         }
//         Set<Integer> set = new HashSet<>();
//         for(int i = 0 ; i < n ; i++){
//             int ingr = sc.nextInt()-1;
//             for(Integer neigh : edges.get(ingr)){
//                 dishes[neigh]-- ;
//                 if(dishes[neigh] == 0){
//                     set.add(neigh);
//                 }
//             }
//             System.out.println(set.size());
//         }
//         sc.close();
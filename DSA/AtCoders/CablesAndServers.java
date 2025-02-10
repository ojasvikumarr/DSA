package AtCoders;

import java.util.*  ;

public class CablesAndServers {
    static int[] parent ; 
    static int[] rank ; 

    public static void init(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ;i < n ; i++){
            parent[i] = i ; 
        }
    }
    public static int find(int x){
        if(parent[x] == x) return x ; 
        return parent[x] = find(parent[x]);
    }
    public static boolean union(int u , int v){
        int uPar = find(u);
        int vPar = find(v);
        if(uPar != vPar){
            if(rank[uPar] == rank[vPar]){
                parent[uPar] = vPar ; 
                rank[vPar]++ ; 
            }else if(rank[uPar] < rank[vPar]){
                parent[uPar] = vPar ; 
            }else{
                parent[vPar] = uPar ; 
            }
            return true; 
        }else{
            return false ;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> edges = new ArrayList<>();
        List<int[]> extraEdges = new ArrayList<>();
        init(n+1);
        for(int i = 1 ; i <= m; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(!union(A , B)){
                extraEdges.add(new int[]{i , A , B});
            }
            edges.add(new int[]{A , B});
        }

        Set<Integer> components = new HashSet<>();
        for(int i = 1 ; i <= n ; i++){
            components.add(find(i));
        }

        List<Integer> compList = new ArrayList<>(components);
        int K = compList.size() - 1 ; 
        System.out.println(K);

        // for(int i = 0 ; i < K ; i++){
        //     int[] cable = extraEdges.get(i);
        //     System.out.println(cable[0] + " " + cable[2] + " " + compList.get(i+1));
        // }
        int itr = 0 ; 
        while(K-- > 0){
            int[] ed = extraEdges.get(itr++) ;
            int id = ed[0];
            int a = ed[1];
            // int b = ed[2];
            //We need to find the component other that the component connected to them 
            int compPar = find(a);
            for(Integer comp : components){
                if(compPar != comp){
                    System.out.println(id + " " + compPar + " " + comp);
                    components.remove(comp);
                    union(compPar , comp);
                    break ; 
                }
            }
        }
        sc.close();
    }
    public static void solve(int[][] edges , int n , int m){

    }
    
}

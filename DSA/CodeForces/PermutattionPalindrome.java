package CodeForces;
import java.util.* ; 

public class PermutattionPalindrome {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            n = sc.nextInt();
            ans.clear();
            for(int i = 1 ; i <= n ; i++){
                a[i] = sc.nextInt();
                p[a[i]] = i ; 
            }
            for(int i = 1 ; i <= n ; i++) b[i] = sc.nextInt();

            solveII();
        }
        sc.close();
    }
    static int MAXM = 200100 ; 
    static List<int[]> ans = new ArrayList<>(); 
    static int[] p = new int[MAXM];
    static int[] a = new int[MAXM];
    static int[] b = new int[MAXM];
    static int n ; 
    public static void work(int x , int y){
        if(x == y) return ; 

        ans.add(new int[]{x , y});
        int temp = a[x] ; 
        a[x] = a[y];
        a[y] = temp ; 

        p[a[x]] = x ; 
        p[a[y]] = y ; 

        temp = b[x] ;
        b[x] = b[y] ;
        b[y] = temp ;

    }
    public static void solveII(){
        int x = 0 ; 
        for(int i = 1 ; i <= n ; i++){
            if(a[i] == b[i]){
                if(n % 2 == 0 || x != 0 ){
                    System.out.println("-1");
                    return ; 
                }
                x = i ; 
            }else if(b[p[b[i]]] != a[i]){
                System.out.println("-1");
                return ; 
            }
        }

        if((n & 1) == 1){
            work(x, (n+1)/2);
        }
        for(int i = 1 ; i <= n/2 ; i++){
            work(p[b[i]] , n- i +1);
        }

        System.out.println(ans.size());
        for(int[] res : ans){
            System.out.println(res[0] + " " + res[1]);
        }
    }
    // public static boolean solve(int[] a , int[] b , int n){
    //     Set<String> set = new HashSet<>();
 
    //     Map<Integer , Integer> map = new HashMap<>();
    //     Map<String , Integer> idx = new HashMap<>();
    //     for(int i = 0 ; i < n ; i++){
    //         String key = a[i] + " " + b[i];
    //         if(a[i] == b[i]){
    //             map.put(a[i] , map.getOrDefault(a[i] , 0)+1);
    //         }
    //         set.add(key);
    //         idx.put(key , i);
    //     }
    //     String odd = "";
    //     int odds = 0 ; 
    //     for(Integer key : map.keySet()){
    //         if(map.get(key) % 2 != 0){
    //             odds++ ;
    //             odd = key + " " + key ;
    //         }
    //     }
    //     if(n %2 == 0 && odds != 0){
    //         return false ;
    //     }else if(n%2 != 0 && odds != 1){
    //         return false ;
    //     }

    //     for(int i = 0 ; i < n ; i++){
    //         String key = b[i] + " " + a[i];
    //         if(!set.contains(key)){
    //             return false ;
    //         }
    //     }

    //     int operations = 0 ; 

    //     if(n%2 != 0){
    //         // we need to move the duplicate odd to the center ?
    //         int i = idx.get(odd) ;
    //         if(i != (n+1)/2){
    //             operations++ ; 
    //             //and swap 
    //             String temp = a[(n+1)/2] + " " + b[(n+1)/2];
    //             idx.put(odd , (n+1)/2);
    //             idx.put(temp , i);
    //         }
    //     }

    //     for(int i = 0 ; i < n/2 ; i++){
    //         String key = a[i] + " " + b[i];
    //         String key2 = b[i] + " " + a[i];
    //         if(idx.get(key2) != n-1-i){
    //             operations++ ;
    //             //and swap 
    //             String temp = a[n-1-i] + " " + b[n-1-i];
    //             idx.put(key2 , n-1-i);
    //             idx.put(temp , i);
    //         }
    //     }

    // }
}

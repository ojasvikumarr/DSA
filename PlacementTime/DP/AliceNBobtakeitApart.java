package PlacementTime.DP;
import java.util.* ; 
public class AliceNBobtakeitApart {
    public void solve(int[] arr){
        int N = arr.length ; 
        //take it apat 
        //generate all possbile subsets 
        // using bitmasking 
        // store the sum as list in map with key as size 
        // then traverse over left side and find appropriat right side and find te min abs difference 
        Map<Integer , List<Integer>> left = new HashMap<>();
        Map<Integer , List<Integer>> right = new HashMap<>();
        int n = N/2 ; 
        for(int mask = 0 ; mask <(1<<n) ; mask++){
            int lf = 0  ;
            int rg = 0 ; 
            int sz = 0 ; 
            for(int i = 0 ; i < n ; i++){
                if(((1<<i)&mask) != 0){
                    lf += arr[i];
                    rg += arr[i+n];
                    sz++ ;
                }
            }
            left.putIfAbsent(sz , new ArrayList<>());
            left.get(sz).add(lf);
            right.putIfAbsent(sz , new ArrayList<>());
            right.get(sz).add(rg);
        }

        int sum = Arrays.stream(arr).sum();
        for(int i = 0 ; i < n ; i++){
            int sz = 0 ; 
            int resz = n-sz ;
            List<Integer> rightset = right.get(resz);
            Collections.sort(rightset);
            for(Integer it : left.get(sz)){
                int idx = Collections.binarySearch(rightset , it);
            }
        }
    }
}

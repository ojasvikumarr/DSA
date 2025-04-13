import java.util.* ; 
public class cp74 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){

        
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                for(int k = j ; k < n ; k++){
                    // int val = (i^j^k);
                    int val = (nums[i]^nums[j]^nums[k]);
                    if(!set.contains(val)){
                        // System.out.println(i + " " + j + " " + k)
                    }
                    set.add(val);
                }
            }
        }
        System.out.print(set.size() + " - ");
        // System.out.println(uniqueXorTriplets(nums));
        System.out.println(solve(nums));
        // // int log = (int)Math.floor(Math.log(n)/Math.log(2))+1;
        // // System.out.println((1<<log)) ; 
        // System.out.print(uniqueXorTriplets(n) );
        // solve(n);

    }
        sc.close();
    }
    public static int uniqueXorTripletsII(int n) {

        if(n == 1 || n == 2){
            return n ; 
        }
        int log = (int)Math.floor(Math.log(n)/Math.log(2))+1;
        return (1<<log) ;
    }
    public static void solve(int n){
        if(n == 1 || n == 2){
            System.out.println(n); 
        }else{

            int log = (int)Math.floor(Math.log(n)/Math.log(2))+1;
            System.out.println((1<<log));

    }
    }
    public static int solveI(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        List<Integer> ls = new ArrayList<>(set);
        int i = 0 ;
        int n = nums.length ; 
        
        while(i < n){
            int j = i+1 ; 
            int k = j+1 ; 
            int val = nums[i]^nums[j] ;
            while(k < n){
                set.add(nums[k]^val); 
                k++ ; 
            }
            i++ ; 
        }

    }
    public static int solve(int[] nums){
        int n = nums.length ; 
        Set<Integer> set = new HashSet<>() ;
        for(int i = 0 ; i < n ; i++){
            int xor = 0 ; 
            for(int j = i ; j < n ; j++){
                xor ^= nums[j];
                set.add(xor);
            }
        }
        return set.size();
    }
    public static int uniqueXorTriplets(int[] nums) {
        int n = nums.length ; 
        Set<Integer> alrdy = new HashSet<>();
        for(int ele : nums) alrdy.add(ele);
        Set<Integer> toBe = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int val = nums[i]^nums[j];
                if(!alrdy.contains(val)){
                    toBe.add(val);
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            for(int ele : toBe){
                int val = ele^num;
                alrdy.add(val);
            }
        }
        return alrdy.size();
    }
   
}

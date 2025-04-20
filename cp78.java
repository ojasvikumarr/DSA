import java.util.* ; 

public class cp78{
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5} ; 
        // System.out.println(new cp78().countSubarraysModuloProduct(nums ,3 , 3)); 
        int k = 3 ;
        int[] res = new int[k];  
        findRemainderSubarrays(nums, k);
        for(int ele : res){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
        public static int[] findRemainderSubarrays(int[] nums, int k) {
            int[] result = new int[k];
            int[] count = new int[k];
            count[1 % k] = 1; // empty product before start
    
            long prod = 1;
    
            for (int num : nums) {
                prod = (prod * num) % k;
    
                for (int mod = 0; mod < k; mod++) {
                    if ((mod * prod) % k == prod) {
                        result[(int) prod]++;
                    } else {
                        // For current prefix prod and previous mod, check:
                        int x = (int) ((prod - (mod * num % k) + k) % k);
                        result[x] += count[mod];
                    }
                }
    
                count[(int) prod]++;
            }
    
            return result;
        }
    public int countSubarraysModuloProduct(int[] nums, int k, int x) {

        int[] freq = new int[k];
        freq[1 % k] = 1;

        long prod = 1;
        int count = 0;

        for (int num : nums) {
            prod = (prod * num) % k;

            // Try all mod values as potential prev_prod % k
            for (int mod = 0; mod < k; mod++) {
                if ((mod * x) % k == prod) {
                    count += freq[mod];
                }
            }

            freq[(int) prod]++;
        }

        return count;
    }
    public int countDivisibleSubarrays(int[] nums, int x) {
        Map<Integer, Integer> required = primeFactors(x); // prime -> count
        Map<Integer, Integer> current = new HashMap<>();
        int n = nums.length;
        int l = 0, res = 0;

        for (int r = 0; r < n; r++) {
            addFactors(current, nums[r]);

            while (l <= r && isValid(current, required)) {
                res += n - r;
                removeFactors(current, nums[l]);
                l++;
            }
        }
        return res;
    }

    private Map<Integer, Integer> primeFactors(int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }
        if (x > 1) map.put(x, 1);
        return map;
    }

    private void addFactors(Map<Integer, Integer> map, int val) {
        for (int i = 2; i * i <= val; i++) {
            while (val % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                val /= i;
            }
        }
        if (val > 1) map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void removeFactors(Map<Integer, Integer> map, int val) {
        for (int i = 2; i * i <= val; i++) {
            while (val % i == 0) {
                map.put(i, map.get(i) - 1);
                val /= i;
            }
        }
        if (val > 1) map.put(val, map.get(val) - 1);
    }

    private boolean isValid(Map<Integer, Integer> current, Map<Integer, Integer> required) {
        for (int key : required.keySet()) {
            if (current.getOrDefault(key, 0) < required.get(key)) return false;
        }
        return true;
    }
}
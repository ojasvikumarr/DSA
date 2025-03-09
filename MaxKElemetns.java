public class MaxKElemetns {
    class Solution {
        class Pair{
            int one ; 
            int two ; 
            int idx ; 
            public Pair(int o , int p , int i){
                this.one = o ; 
                this.two = p ; 
                this.idx = i ; 
            }
        }
        public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
            int n = nums1.length ; 
            long[] result = new long[n];
    
            List<Pair> ls = new ArrayList<>();
    
            for(int i = 0 ; i < n ; i++){
                ls.add(new Pair(nums1[i] , nums2[i] , i));
            }
            Collections.sort(ls , (a , b) -> b.one - a.one);
    
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0 ; 
            int count = 0 ; 
            for(int i = n - 1; i >= 1 ; i--){
                count++ ;
                // System.out.println(ls.get(i).one + " " + ls.get(i).two + " " + ls.get(i).idx);
                pq.add(ls.get(i).two);
                if(count > k){
                    sum -= pq.poll();
                    count-- ; 
                }
                sum = sum + ls.get(i).two ; 
                int index = ls.get(i-1).idx ; 
                // System.out.println(index + " - " + sum);
                if(ls.get(i).one == ls.get(i-1).one){
                    result[index] = result[ls.get(i).idx];
                }else{
                    result[index] = sum ;
                }
            }
            return result ; 
        }
    }
}

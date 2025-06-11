public class Day247{
    class Solution {
    public int maxDifference(String s) {
        Map<Integer , Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            int val = c - 'a';
            map.put(val , map.getOrDefault(val , 0)+1);
        }
        List<Integer> odd = new ArrayList<>();
        int maxO = 0 ;
        List<Integer> even = new ArrayList<>();
        int minE = 101 ; 
        for(int key : map.keySet()){
            int freq = map.get(key) ;
            if(freq% 2 != 0){
                maxO = Math.max(maxO , freq);
            }else{
                minE = Math.min(minE , freq);
            }
        }
        return maxO-minE ;
    }
}
}
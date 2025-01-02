public class Day89 {
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            //Formation of prefixsum array 
            int n = queries.length ;
            int[] preSum = new int[words.length];
            if(checkVowel(words[0]) == true) preSum[0] = 1 ;
            for(int i = 1 ; i < words.length ; i++){
                preSum[i] = preSum[i-1] + (checkVowel(words[i]) ? 1 : 0);
            }
            int[] result = new int[n];
            int i = 0 ; 
            for(int[] query : queries){
                int start = query[0];
                int end = query[1];
                if(start == 0){
                    result[i++] = preSum[end];
                }else{
                    result[i++] = preSum[end] - preSum[start-1];
                }
            }
            return result ;
        }
        public boolean checkVowel(String str){
            List<Character> vowels = new ArrayList<>();
            vowels.add('a');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            vowels.add('e');
            if(vowels.contains(str.charAt(0)) && vowels.contains(str.charAt(str.length()-1))){
                return true ;
            }
            return false ;
        }
    }
}

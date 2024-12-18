package LeetCode;

public class Day78 {
    class Solution {
        public int[] finalPrices(int[] prices) {
            // int[] dummy = Arrays.copyOf(prices , prices.length);
            // Arrays.sort(dummy);
            // // if(dummy.equals(prices)) return prices ;
            // if(Arrays.equals(dummy ,prices)) return prices ;
    
            for(int i = 0 ; i < prices.length ; i++){
                for(int j = i+1 ; j < prices.length ; j++){
                    if(prices[i] >= prices[j]){
                        prices[i] = prices[i] - prices[j];
                        break ;
                    }
                }
            }
            return prices ;
        }
    }
}

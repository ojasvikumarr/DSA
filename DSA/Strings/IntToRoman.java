package Strings;

public class IntToRoman {
    class Solution {
        int[] val = new int[]{1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1};
        String[] sym = new String[]{"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < 13 ; i++){
                if(num == 0) break ;
                int times = num / val[i];
                while(times-- > 0){
                    sb.append(sym[i]);
                }
                num %= val[i];
            }
            return sb.toString();
        }
    }
}
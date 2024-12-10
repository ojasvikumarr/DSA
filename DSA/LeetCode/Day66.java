import java.util.TreeMap;

public class Day66 {
    class Solution {
    public int maximumLength(String s) {
        TreeMap<String , Integer> map = new TreeMap<>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++ ){
            StringBuilder sb = new StringBuilder("");
            for(int j = i ; j < n ; j++){
                sb.append(s.charAt(j));
                // System.out.println(sb);
                // if(!map.containsKey(sb.toString())){
                //     map.put(sb.toString() , 1);
                // }else{
                    map.put(sb.toString() , map.getOrDefault(sb.toString() , 0)+1);
                // }
            }
        }
        int maxi = -1 ;
        for(String str : map.keySet()){
            System.out.println(str + " = " + map.get(str));

            if(checkStr(str) && map.get(str) >= 3){
                // System.out.println(maxi);
                maxi = Math.max(maxi , str.length());
            }
        }
        return maxi ;
    }
    public boolean checkStr(String s){
        if(s.length() == 0) return false ;
        char c = s.charAt(0);
        for(Character ch : s.toCharArray()){
            if(ch != c) return false ;
        }
        return true ; 
    }
}
}

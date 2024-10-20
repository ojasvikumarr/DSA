import java.util.* ;
public class Day13 {

    // Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// 
    //wrong approach
    public int firstUniqChar(String s) {

        int n = s.length();
        boolean[] occ = new boolean[n];
        char[] ch = s.toCharArray();

        for(int i =0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if(ch[i] == ch[j]){
                    occ[i] = true ;
                }
            }
        }
        int i= 0 ;
        while( i!= n-1 ){
            if(!occ[i]){
                return i ;
            }
            i++ ;
        }
        return -1 ;
    }

    public int occurence(String s){
        HashMap<Character , Integer> map = new HashMap<>();

        for(char a : s.toCharArray()){
            map.put(a , map.getOrDefault(a , 0) + 1);
        }
        for(int i = 0 ; i< s.length() ; i++){
            if(map.get(s.charAt(i)) == 1){
                return i ;
            }
        }
        return -1 ;
    }
}

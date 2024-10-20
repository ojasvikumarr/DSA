import java.util.* ;    

public class Day20 {

    public void Hellper(char[] arr , List<List<Character>> ans , int idx , List<Character> ds){
        if(idx == arr.length){
            ans.add(new ArrayList<>(ds));
            return ;
        }
        ds.add(arr[idx]);
        Hellper(arr, ans, idx+1, ds);
        ds.remove(ds.size()+1);
        Hellper(arr, ans, idx+1, ds);
    }
    public int countSubStrings (String s){
        char[] charArr = s.toCharArray();
        List<List<Character>> ans = new ArrayList<>();
        Hellper(charArr , ans , 0 , new ArrayList<>());
        return ans.size() ;
    }
}


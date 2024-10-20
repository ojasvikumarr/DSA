package BackTracking;

public class Subsets {
    public static void FindSubsets( String str , int i , String ans){
        if(str.length() == i){
            if(ans.length() == 0){
                System.out.print(" NUll");
            }
            else{
            System.out.println(ans);
        }
            return;
        }

        FindSubsets(str, i+1, ans+str.charAt(i));
        FindSubsets(str, i+1, ans);
    }
    public static void main (String arg[]){
        String str = "abc";
        FindSubsets(str, 0, "");
    }    
}

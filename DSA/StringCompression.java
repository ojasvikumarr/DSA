public class StringCompression {
    public static String Compress(String str){
        String newstr = "";
        //int count = 1 ;//had to use Integer instead of int as toString function didnt work on objects
        Integer count = 1;
        for (int i = 0 ; i<str.length() ; i++){
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newstr += str.charAt(i);
            if(count >1){
                newstr += count.toString();//this toString function changes integer value into string function                
            }
            
        }
        return newstr;
    }

    public static void main (String args []){
        String str = "aabbbbbbaabbbbccccbbbddddbbbfff";
        String ojas = "Ojasvi kumar hulla hulla ";
        System.out.println(Compress(str)) ;
        System.out.println(Compress(ojas)) ;
    }
}
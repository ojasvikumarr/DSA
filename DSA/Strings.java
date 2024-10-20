import java.util.*;
public class Strings{
    public static void Palindrome(String str){
        int n = str.length();
        for( int i=0 ; i<str.length()/2 ;i++){
            if(str.charAt(i) == str.charAt(n-1-i)){
            System.out.println("Your word is a palindrome!!");
            //return true;
            }
            else{
                System.out.println("Your word is not a palindrome!!");
            }
            
        }
        //return false;
        
}
    public static void printCHAR(String str){
        int n;
        n= str.length() ;
        for(int i = 0 ; i<=n; i++){
            System.out.print(str.charAt(i)+" ");
        }
    }
    public static void main ( String args[] ){
        try (Scanner sc = new Scanner ( System.in )) {
        }
        //String  name;
        //name = sc.nextLine();
       // System.out.println(name); 
        
        //concatenation String Fullname = Firstname + " " + Lastname;
        /*String Firstname = "Ojasvi";
        String Lastname = "Kumar";
        String Fullname = Firstname + " " + Lastname;
        System.out.println(Fullname);
        System.out.println(Fullname.charAt(2));
        printCHAR(Fullname);
        
        String h ="HELLOLdLEH";
        Palindrome(h);
        */
        String s1 ="Tony";
        String s2 ="Tony";//here s2 and s2 poinrs towards the same tony 
        String s3 =new String("Tony");//while here when new string is made then a new tony is also made i.e they are not the same
        if(s1 == s2){
            System.out.println("They are the same");
        }
        else{
            System.out.println("they are nto the same");
        }
        if(s1 == s3){
            System.out.println("They are the same");
        }
        else{
            System.out.println("they are nto the same");
        }
        //here the s1.equals(s3)checks whether the values stored in the Strings are same or not 
        if(s1.equals(s3)){
            if(s1 == s2){
                System.out.println("They are the same");
            }
            else{
                System.out.println("they are nto the same");
            }

        }
    }
}
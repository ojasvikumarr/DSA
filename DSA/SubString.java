//import java.util.*;
public class SubString{
    public static String SUBString(String str ,int si , int ei){
        String name = "";
        for(int i = si ; i<ei ;i++){
            name += str.charAt(i);
        }
        return name;
    }
    public static void main (String args[]){
        String name = "Ojasvikumar" ;
        
        System.out.println(SUBString(name,1,4));
        //Or
        System.out.println(name.substring(1,4));
    }
}
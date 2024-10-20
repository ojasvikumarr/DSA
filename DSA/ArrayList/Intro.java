

import java.util.ArrayList;

public class Intro {
    public static void main( String args[] ){
        //ClassName ObjectName = new Classname();
        ArrayList<Integer> Lists = new ArrayList<>();
        ArrayList<String> Lists2 = new ArrayList<>();
        ArrayList<Boolean> Lists3 = new ArrayList<>();
        //Add Element
        Lists2.add("h");
        Lists3.add(true);
        Lists.add(1);
        Lists.add(2);
        Lists.add(3);
        Lists.add(4);
        Lists.add(5);
        Lists.add(6);
        System.out.println(Lists);

        //Get Element 
        int element = Lists.get(2);
        System.out.print(element);

        //Remove Element 
        int element2 = Lists.remove(1);
        System.out.println(element2);

        //Set element 
        Lists.set(3 , 100); //At index number 3 the number is to be replaced by 100
        System.out.print(Lists);

        //COntain Element 
        System.out.println(Lists.contains(4));
        System.out.println(Lists.contains(1000));

        //Size ELement
        System.out.println(Lists.size());

        //Reverse print of the elements of the array 
        for( int i = Lists.size()-1 ; i>=0 ; i--){
            System.out.print(Lists.get(i) +" ");
        }
        System.out.println();

        //Max Value in the list

        int max = Integer.MIN_VALUE;
        for( int i = 0 ; i<Lists.size() ; i++){
            if( max <Lists.get(i)){
                max = Lists.get(i);
            }
        }
        System.out.println("MAx element is equal to :"+ max);
    }
    
}

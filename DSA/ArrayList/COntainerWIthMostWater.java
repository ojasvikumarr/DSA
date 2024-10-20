import java.util.*;
public class COntainerWIthMostWater {
    public static int MaxxWater ( ArrayList<Integer> height){
        int i = 0 ;
        int j = height.size()-1;
        int maxWater = 0 ;
        while(i<=j){
            //wiidth;
            int width = j-i ;
            //height 
            int ht = Math.min(height.get(i) , height.get(j));   
            maxWater = Math.max( maxWater , ht*width );
            if(height.get(i) <height.get(j)){
                i++ ;
            }
            else{
                j-- ;
            }
            
        }
        return maxWater ;
    }
    public static int MaxWater ( ArrayList<Integer> height){
        int maxwater = 0 ;
        //brute force -- O(n^2)
        for( int i= 0 ; i< height.size() ; i++){
            for( int j = i+1 ; j<height.size() ; j++){
                int ht = Math.min(height.get(i) , height.get(j));
                int width = j- i ;
                int currWater = width*ht ;
                maxwater = Math.max(currWater , maxwater);
            }
        }
        return maxwater;
    }
   
    public static void main(String args[]){
        ArrayList<Integer> Height = new ArrayList<>();

    Height.add(1);
    Height.add(8);
    Height.add(6);
    Height.add(2);
    Height.add(5);
    Height.add(4);
    Height.add(8);
    Height.add(3);
    Height.add(7);

    System.out.println(MaxWater(Height));
    System.out.print(MaxxWater(Height));
    }
}

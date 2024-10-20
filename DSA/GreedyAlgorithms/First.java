package GreedyAlgorithms;
import java.util.*;
public class First {
    public static void main( String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        int activities[][] = new int[start.length][3];
        for(int i =0 ; i<start.length ; i++ ){
            activities[i][0] = i ;
            activities[i][1] = start[i];
            activities[i][2] = end[i]; 
        }

        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));//lamda function : short form of a big function

        //end time is sorted ;
        int maxAct = 0 ; 
        ArrayList<Integer> ans = new ArrayList<>();

        maxAct = 1 ;
        ans.add(0);
        int lastEnd = end[0];
        for( int i = 0 ;i < end.length ; i++ ){
            if(start[i] >= lastEnd){
                maxAct++ ;
                ans.add(i);
                lastEnd = end[i];
            }
        } 
        System.out.println("MaxAct : " + maxAct);
        for(int i = 0 ; i < ans.size() ; i++){
            System.out.print("A"+ ans.get(i) + " ");
        }
        System.out.println();
    }
}

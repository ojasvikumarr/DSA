package GreedyAlgorithms;
import java.util.*;
public class ActivitySelection {
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        int maxAct = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();
        //1st activity we always do as the endtime of the activities is alrady sorted so therefore the first activity will be the least time taking
        maxAct = 1 ;
        int lastEnd = end[0];
        ans.add(0);
        for ( int i = 0 ; i < end.length ; i++ ){
            if( start[i] >= lastEnd){
                maxAct++ ;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("THe maximum activities are: "+maxAct);
        for(int i = 0 ; i < ans.size() ; i++ ){
            System.out.print("A"+ans.get(i)+" ");
        }

    }
}

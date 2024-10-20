package PriorityQueue;
import java.util.PriorityQueue ;
public class L5 {
    //minimum cost for the rope
    public static void main(String args[]){
        int ropes[] = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < ropes.length ; i++ ){
            pq.add(ropes[i]);
        }
        int cost = 0 ;
        int min = 0 ;
        int min2 = 0 ;
        while( pq.size() > 1 ){
            min = pq.remove();
            min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }

        System.out.println("THe minimum cost to connect the ropes will be : " + cost);
    }
}

import java.util.PriorityQueue;

public class Day75 {
    class Solution {
    class Pair{
        int pass ; 
        int total ; 
        public Pair(int p , int t){
            this.pass = p ; 
            this.total = t ; 
        }
        public double gain(){
            return (double)(pass+1)/(total+1) - (double)(pass)/(total) ;
        }
    }
    public double maxAverageRatio(int[][] classes, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> Double.compare(b.gain() , a.gain()));
        for (int[] cls : classes) {
            pq.offer(new Pair(cls[0], cls[1]));
        }
        while(k > 0){
            Pair p = pq.poll(); 
            p.pass++ ;
            p.total++ ;
            pq.offer(p);
            k-- ;
        }
        double ans = 0.0 ; 
        while(!pq.isEmpty()){
            Pair q = pq.poll();
            ans += (double)q.pass/q.total ;
        }
        return ans/classes.length ; 
    }
}
}

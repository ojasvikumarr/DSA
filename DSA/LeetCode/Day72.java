public class Day72 {
    class Solution {
        public long pickGifts(int[] gifts, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
            for(Integer gift : gifts){ 
                pq.add(gift);
                // System.out.println(gift);
            }
            while(k > 0){
                int giftt = pq.poll();
                // System.out.println(giftt);
                int giftLeft = (int)Math.floor(Math.sqrt(giftt));
                pq.offer(giftLeft);
                k-- ;
            }
            long totalGifts = 0 ; 
            while(!pq.isEmpty()){
                totalGifts += pq.poll();
            }
            return totalGifts ;
        }
    }
}

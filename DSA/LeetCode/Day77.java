public class Day77 {
    class Solution {
        class Pair{
            char c ; 
            int freq ;
            public Pair(char c , int f){
                this.c = c ; 
                this.freq = f ;
            }
        }
        public String repeatLimitedString(String s, int repeatLimit) {
            HashMap<Character , Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c , map.getOrDefault(c , 0)+1);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Character.compare(b.c , a.c));
            for(Character Key : map.keySet()){
                pq.add(new Pair(Key , map.get(Key)));
            }
            StringBuilder sb = new StringBuilder();
            while(!pq.isEmpty()){
                Pair p = pq.poll();
                char letter = p.c ;
                int frequency = p.freq ;
                int limit = repeatLimit ;
                while(limit > 0 && frequency > 0){
                    sb.append(letter);
                    // System.out.println(sb);
                    frequency-- ;
                    limit-- ;
                }
                if(frequency > 0){
                    if (pq.isEmpty()) {
                         break;
                    }
                    Pair q = pq.poll();
                    char lq = q.c ;
                    int fq = q.freq ;
                    sb.append(lq); 
                    fq-- ;
                    if(fq > 0)
                    pq.offer(new Pair(lq , fq));
                    pq.offer(new Pair(letter , frequency));
                }
            }
            return sb.toString();
        }
    }
}

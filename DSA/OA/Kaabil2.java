package OA;
import java.util.* ;
public class Kaabil2 {
    static class pair{
        int x ;
        int y ; 

        public pair(int x , int y){
            this.x = x ;
            this.y = y ;
        }
    }
    static class Pairs{
        pair a ;
        pair b ;
        public Pairs(pair a , pair b){
            this.a = a ;
            this.b = b ;
        }
        @Override
        public String toString() {
            return "(" + a.x + "," + a.y + ") - (" + b.x + "," + b.y + ")";
        }
    }
    public static void Generator(Set<pair> A , Set<pair> B , int m , int n){
        for(int i = 0 ; i < m ; i++){
            A.add(new pair((int)(Math.random()*10), (int)(Math.random()*10)));
        }
        for(int i = 0 ; i < n ; i++){
            B.add(new pair((int)(Math.random()*10), (int)(Math.random()*10)));
        }
    }
    public static void main(String[] args){
        Set<pair> A = new HashSet<>() ;
        Set<pair> B = new HashSet<>() ;
        ArrayList<Pairs> ans = new ArrayList<>() ;
        int m = 100 ;
        int n = 99 ;
        Generator(A , B , m , n);
        for(pair p : B){
            if(A.contains(p)){
                ans.add(new Pairs(p, p));
            }
        }
        for(Pairs p : ans){
            System.out.println(p.toString());
        }
    }
}

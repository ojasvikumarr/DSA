import java.util.* ; 

public class cp44 {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] centers = new int[n];
            for(int i = 0 ; i < n ; i++) centers[i] = sc.nextInt();
            int[] radii = new int[n];
            for(int i = 0 ; i < n ; i++) radii[i] = sc.nextInt();
            solveII(n , m , centers , radii);
        }
        sc.close();
    }
    static class Pair{
        int x ; 
        int y ; 
        public Pair(int x , int y){
            this.x = x ; 
            this.y = y ; 
        }
    }
    static class circle{
        int x ;
        int r ; 
        public circle(int x , int r){
            this.x = x ; 
            this.r = r ; 
        }
    }
    static int MOD = (int)1e9 + 7 ; 
    public static void solveII(int n , int m , int[] centers , int[] radii){
        List<circle> circles = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            circles.add(new circle(centers[i] , radii[i]));
        }
        circles.sort((a , b) -> Integer.compare(b.r , a.r));
        //Now sorted in descending radi 
        boolean[] skip  = new boolean[n];
        for(int i = 0 ; i < n ;i++){
            if(skip[i]) continue ; 
            int x1 = circles.get(i).x ; 
            int r = circles.get(i).r ; 
            for(int j = i+1 ; j < n ; j++){
                int x2 = circles.get(j).x ; 
                int r2 = circles.get(j).r ; 
                if(Math.abs(x1-x2) + r2 <= r) skip[j] = true ;
            }
            for(int x = x1-r ; x <= x1+r ; x++){
                int range = (int) Math.floor(Math.sqrt(Math.pow(r,2) - Math.pow(x-x1 , 2)));
                for(int y = -range ; y <= range; y++){
                    long h = hasher(x , y);
                    set.add(h);
                }
            }
        }
        System.out.println(set.size());
        return ; 
    }
    public static long hasher(int x , int y){
        return ((long)x<<32)^ (y%(1L<<32));
    }
    public static void solve(int n , int m , int[] centers , int[] radii){
        Set<Long> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            int x1 = centers[i];
            int r = radii[i];
            for(int x = x1 - r ; x <= x1 + r ; x++){
                int range = (int) Math.floor(Math.sqrt(r*r - (x-x1)*(x-x1)));
                for(int y = -range ; y <= range ; y++){
                    // if(y == 0) set.add(Objects.hash(x , y));
                    // else{
                        // set.add(new Pair(x , y));
                        long hash = ((long) x<<32) ^ (y%(1L <<32));
                        set.add(hash);
                    // }
                }
            }
        }
        System.out.println(set.size());
        return ; 
    }
}

public class TilingProblem {
    public static int Tiling ( int n ){
        if ( n == 0 || n == 1){
            return 1;
        }
        //kAAAM
        //Vertical choice 
        int Fnm1 = Tiling(n-1);

        //horizontal choice
        int Fnm2 = Tiling(n-2);
        int totalWays = Fnm1 + Fnm2 ;
        return totalWays;

    }
    public static void main( String args[]){
        System.out.println(Tiling(3));
    }
}

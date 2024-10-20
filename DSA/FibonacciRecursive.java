public class FibonacciRecursive {
    public static int Fib(int n){
        // if (n == 1){
        //     return 1;
        // }
        // if ( n == 0){
        //     return 0 ;
        // }

        if ( n == 1 || n == 0){
            return n;
        }
        int fnm1 = Fib(n-1);
        int fnm2 = Fib(n-2);
        int fn = fnm1 + fnm2 ;
        return fn ;
    }
    public static void main ( String args[]){
        System.out.print(Fib(25));
    }
}

// watch the video of fibonacci again for stack analysis
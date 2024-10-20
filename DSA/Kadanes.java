public class Kadanes{
    public static void kadanes(int n[]){
        int cs = 0 ;
        int ms = Integer.MIN_VALUE;
        for (int i = 0 ; i < n.length ; i++){
            cs = cs+n[i];
            if ( cs < 0 ){
                cs = 0 ;
            }
            ms = Math.max(cs , ms);
        }
        if ( ms == 0 ){
            //int k = 0 ;
            int l = Integer.MIN_VALUE;
            for( int i = 0 ; i <n.length;i++){
                l = n[i];
            }
            System.out.println("our sum is: "+ l);
        }
        else{

        System.out.println("our max sum is: "+ms);
        }
    }
    public static void main ( String args[] ){
        int numbers[]={-2,-3,-1,-5,-1,-2,-5};
        kadanes(numbers);
    }

}
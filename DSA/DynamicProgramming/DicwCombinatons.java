package DynamicProgramming;

public class DicwCombinatons {
    public static void main(String[] args){
        int n = 3 ; 
        int[] dice = {1 , 2 , 3 , 4 , 5 , 6};
        System.out.println(solve(dice , n));
    }
    public static int solve(int[] dice , int n){
        if(n == 0 ){
            return 1 ;
        }else if(n < 0){
            return 0 ;
        }
        int pick = 0;
        int notpick =0;
        for(int i=0;i<dice.length;i++){
            pick += solve(dice,n-dice[i]);
            notpick += solve(dice,n);
        }
        return pick + notpick ; 
    }

}

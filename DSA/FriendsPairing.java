public class FriendsPairing {

    //in a party a person can either remain single or mingle with other person that is form a pair
    //but once a pair is formed then they cant change there partner
    //so WAP to identfy the number of ways in which the party is held
    public static int FriendPairing(int n){
        //base value
        if ( n == 1|| n == 2){
            return n;
        }
 /*       //kaam
        //single
        int fnm1 = FriendPairing(n - 1);

        //paired
        int fnm2 = FriendPairing(n - 2);
        int pairways = (n-1)*fnm2 ;

        //totways
        int totalWays = fnm1 + pairways ;
        return totalWays;
 */
        return FriendPairing(n-1) + (n-1)*FriendPairing(n-2);
    }
    public static void main ( String args[]){
        System.out.println( FriendPairing(3));
    }
}

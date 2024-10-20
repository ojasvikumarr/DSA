public class Stocks {
    public static int stocks(int n[]){
        int buyPrice = Integer.MAX_VALUE;
        int Maxprofit = 0 ;
        for ( int i = 0 ; i < n.length ; i++ ){
            if(buyPrice < n[i]){
                int profit = n[i] - buyPrice;//profit
                Maxprofit = Math.max(profit,buyPrice);//today's profit
            }
            else{
                buyPrice = n[i];
            }
        }
        return Maxprofit;
    } 
    public static void main ( String args [] ){
        int prices [] = {7,1,5,3,6,4};
        System.out.println(stocks(prices));
        System.out.println("hello world");
    }
}
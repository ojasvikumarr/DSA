package BackTracking;
public class NQueens {
    public static boolean isSafe( char board[][] , int row , int col){
        //vertical up 
        for( int i = row-1 ; i>= 0 ; i--){
            if(board[i][col] == 'Q'){
            return false;
            }
        }
        //diaf left up 
            for ( int i = row-1 , j = col-1 ; i>=0 && j>=0 ; i-- , j--){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
            // diaf right up
            for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            return true;
    }
    
    static int count = 0; //to fnd the number of ways
    public static void nQueens( char board[][] , int row){
    //base
    if(row == board.length){
        
        System.out.println("-------Chess Board------");
        printBoard(board);
        count++ ;
        return;
    }
    //column loop
    for(int j = 0 ; j<board.length ; j++){
        if(isSafe(board, row, j)){
        board[row][j] = 'Q';
        nQueens(board, row+1);
        board[row][j]= 'x';//humne queen ko utha liya while backtrcking
        }
    }
    }
    public static void printBoard( char board[][]){
        for( int i = 0 ; i<board.length ; i++){
            for( int j = 0 ; j<board.length ; j++){
                System.out.print(board[i][j]+" ");
                
            }
            
            System.out.println();
        }
    }
    public static void main( String args[]){
        int n = 4 ;
        char board[][] = new char[n][n];//board ko memory meinbanaya 

        //initialize
        for( int i = 0 ; i<n ; i++){//board ko humne output kiya 
            for( int j = 0 ; j<n ; j++){
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
        System.out.println("Total umber of ways Nqueens can be set in nth board :"+count);
    }
}

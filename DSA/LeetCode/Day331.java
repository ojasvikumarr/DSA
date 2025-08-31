class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board){
        int n = board.length ; 
        int m = board[0].length ; 

        // choose a number that will be valid , put it if satisfies all have at it or remove it 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(board[i][j] == '.'){

                    for(char c = '1' ; c <= '9' ; c++){
                        if(isValid(board , i , j , c)){
                            board[i][j] = c ; 

                            if(solve(board)){
                                //for the board to be valid , there will be a true returned 
                                return true ; 
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    //when no digiit can be placed 
                    return false ;
                }
            }   
        }
        return true ;
    }
    public boolean isValid(char[][] board , int i , int j ,  char c){
        for(int k = 0 ; k < 9 ; k++){
            if(board[i][k] == c) return false ; 
            if(board[k][j] == c) return false ; 
            int boxRow = 3 * (i/3) + k/3 ; 
            int boxCol = 3 * (j/3) + k%3 ; 
            if(board[boxRow][boxCol] == c) return false ;
        }
        return true ;
    }
}
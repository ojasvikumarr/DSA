class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length ; 
        int m = board[0].length ; 
        
        for(int i = 0 ;i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] != '.'){
                    char c = board[i][j];
                    board[i][j] = '.';
                    if(isValid(board , i , j , c) == false){
                        return false ; 
                    }
                    board[i][j] = c ; 
                }
            }
        }
        return true ; 
    }
    public boolean isValid(char[][] board , int row , int col , char c){
        for(int k = 0 ; k < 9 ; k++){
            if(board[row][k] == c) return false ; 
            if(board[k][col] == c) return false ; 
            int boxRow = 3*(row/3) + k / 3 ; 
            int boxCol = 3*(col/3) + k % 3 ; 
            if(board[boxRow][boxCol] == c) return false ;
        }
        return true ;
    }
}
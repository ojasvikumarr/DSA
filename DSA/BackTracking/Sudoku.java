package BackTracking;

public class Sudoku {
    public static boolean isSafe(int sudoku[][] , int row , int col , int digit){
        //for row 
        for ( int i = 0 ; i<= 8 ; i++)
            if( sudoku[row][i] == digit){
                return false;
            }
        
        //for col
        for ( int j = 0 ; j<= 8 ; j++){
            if( sudoku[j][col] == digit ){
                return false;
            }
        }
        //calculating grid 
        int sc = (col/3)*3;
        int sr = (row/3)*3;
        for ( int i = sc ; i <= sc+3 ; i++){
            for( int j = sr ; j <= sr+3 ; j++){
                if(sudoku[sr][sc] == digit){
                    return false ; 
                }
            }
        }
        return true ;
    }
    
    public static boolean SudokuSolver( int sudoku[][] , int row , int col){
        //base case
        if(row == 9 || col == 9){
            return true;
        }
        else if( row == 9 ){//jab hum last row pe phoch jate hai and koi bhi solution nhi bachta aage
            return false ;
        }
        //rescursion
        int nextRow = row, nextCol = col+1;
        if( col+1 == 9 ){
            nextRow += 1 ;
            nextCol = 0 ;
        }
        if(sudoku[row][col] != 0){
            return SudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digits = 1 ; digits <= 9 ; digits++){
            //int digit;
            if( isSafe(sudoku , row ,col , digits)){
                sudoku[row][col] = digits ;
                if(SudokuSolver(sudoku, nextRow, nextCol)){//Sol exists
                    return true ;
                }
                sudoku[row][col] = 0 ;
            }
        }
        return false ;
    }
        public static void PrintSudoku(int sudoku[][]){
            for(int i= 0 ; i<9 ; i++){
                for(int j= 0 ;j<9 ; j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
        }
    public static void main( String args[] ){
        int sudoku[][] =   {{ 0, 0, 8, 0, 0, 0, 0, 0, 0},
                            { 4, 9, 0, 1, 5, 7, 0, 0, 2},
                            { 0, 0, 3, 0, 0, 4, 1, 9, 0},
                            { 1, 8, 5, 0, 6, 0, 0, 2, 0},
                            { 0, 0, 0, 0, 2, 0, 0, 6, 0},
                            { 9, 6, 0, 4, 0, 5, 3, 0, 0},
                            { 0, 3, 0, 0, 7, 2, 0, 0, 4},
                            { 0, 4, 9, 0, 3, 0, 0, 5, 7},
                            { 8, 2, 7, 0, 0, 9, 0, 1, 3}};
        if(SudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution exists");
           PrintSudoku(sudoku);
        }
        else{
            System.out.println("SOlution doesn't exists!!");
        }
    }
}

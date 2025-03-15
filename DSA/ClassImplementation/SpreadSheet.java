package ClassImplementation;

public class SpreadSheet {
    class Spreadsheet {
        int[][] grid ; 
        public Spreadsheet(int rows) {
            grid = new int[rows][26];
        }
        
        public void setCell(String cell, int value) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.valueOf(cell.substring(1))-1;
            grid[row][col] = value ; 
        }
        
        public void resetCell(String cell) {
            int col = cell.charAt(0) - 'A';
            int row = Integer.valueOf(cell.substring(1))-1;
            grid[row][col] = 0 ; 
        }
        
        public int getValue(String formula) {
            // String x = formula.substring(1 , 2) ; 
            formula = formula.substring(1);
            int X = 0 ; 
            String part[] = formula.split("\\+");
            if(formula.charAt(0) >= 'A' && formula.charAt(0) <= 'Z'){
                X = decode(part[0]);
            }else{
                X = Integer.valueOf(part[0]);
            }
            
            int Y = 0 ;
            
            if(part[1].charAt(0) >= 'A' && part[1].charAt(0) <= 'Z'){
                Y = decode(part[1]);
            }else{
                Y = Integer.valueOf(part[1]);
            }
            return X+Y ; 
        }
        
        public int decode(String part){
            //=X+Y
            int col = part.charAt(0) - 'A';//sorted no problem
            //here need to determine the 
            int row = Integer.valueOf(part.substring(1))-1;
            return grid[row][col];
        }
    }
    
    /**
     * Your Spreadsheet object will be instantiated and called as such:
     * Spreadsheet obj = new Spreadsheet(rows);
     * obj.setCell(cell,value);
     * obj.resetCell(cell);
     * int param_3 = obj.getValue(formula);
     */
}

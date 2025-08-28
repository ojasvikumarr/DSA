class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ;
        for(int i = 0 ; i < n ; i++){
            //Traversing the row 
            List<Integer> ls = new ArrayList<>();
            int x = i ; 
            int y = 0 ; 
            while(x < n && y < m){
                ls.add(grid[x][y]);
                x++ ; 
                y++ ;
            }
            Collections.sort(ls , (a , b) -> b - a);//ascending
            //Storing
            x = i ; 
            y = 0 ; 
            int idx = 0 ; 
            while(x < n && y < m){
                grid[x][y] = ls.get(idx);
                x++ ; y++ ; idx++ ; 
            }
        }

        for(int j = 1 ; j < m; j++){
            List<Integer> ls = new ArrayList<>() ; 
            int x = 0 ; 
            int y = j ; 
            while(x < n && y < m){
                ls.add(grid[x][y]);
                x++ ; 
                y++ ;
            }
            Collections.sort(ls ,(a,b) -> a - b);//ascending
            //Storing
            x = 0 ; 
            y = j ; 
            int idx = 0 ; 
            while(x < n && y < m){
                grid[x][y] = ls.get(idx);
                x++ ; y++ ; idx++ ; 
            }
        }
        return grid ; 
    }
}
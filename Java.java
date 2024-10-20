import java.util.Queue;
import java.util.* ;

public class Java {
    class Solution {
    public void solve(char[][] board) {
        int n = board.length , m = board[0].length ;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            if(board[i][0] == 'O' && vis[i][0] == false ){
                bfs(board , i , 0 , vis);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == false ){
                bfs(board , i , m-1 , vis);
            }
        }
        for(int j = 0 ; j < m ; j++){
            if(board[0][j] == 'O' && vis[0][j] == false ){
                bfs(board , 0 , j , vis);
            }
            if(board[n-1][j] == 'O' && vis[n-1][j] == false ){
                bfs(board , n-1 , j , vis);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'O' && vis[i][j] == false){
                    board[i][j] = 'X' ;
                }
            }
        } 
    }
    public void bfs (char[][] board , int i , int j , boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true ;
        q.add(new Pair(i , j));
        while(!q.isEmpty()){
            int r = q.peek().row ;
            int c = q.peek().col ;
            q.remove();
            int[] drow = {-1 , 0 , 1 , 0};
            int[] dcol = {0 , 1 , 0 , -1};
            for(int k = 0 ; k < 4 ; k++){
                int ro = r + drow[k];
                int co = c + dcol[k];

                if( (ro >= 0 || co >= 0 || ro <= board.length-1 || co <= board[0].length-1) && vis[ro][co] == false){
                    if(board[ro][co] == 'O'){
                        if(ro == 0 || co == 0 || ro == board.length-1 || co == board[0].length-1)
                        vis[r][c] = true ;
                        q.add(new Pair(ro , co));
                    } 
                }
            }
        }


    }
    class Pair{
        int row ;
        int col ;
        public Pair(int x , int y){
            this.row = x ;
            this.col = y ;
        }
    }
    
}
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        Set<String> set = new HashSet<String>();
        for(int i = 0 ; i < wordList.size() ; i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().str;
            int step = q.peek().steps;
            q.remove();
            if(word == endWord) return step ;
            for(int i = 0 ; i < word.length() ; i++){
                for(char c = 'a' ; c <= 'z' ;c++){
                    char[] newWord = word.toCharArray();
                    newWord[i] = c ;
                    String replacedWord = new String(newWord);
                    if(set.contains(replacedWord) == true){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord , step+1));
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String str ;
        int steps ;
        public Pair(String str , int st){
            this.str = str ;
            this.steps = st ;
        }
    }

    public static int NoOfComponents(int[][] grid){
        int n = grid.length , m = grid[0].length ;
        boolean[][] vis = new boolean[n][m];
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == false && grid[i][j] == 'O'){
                    dfs(grid , i , j , vis , n , m);
                    count++ ;
                }
            }
        }
        return count ;
    }
    public static void dfs(int[][] grid , int i , int j , boolean[][] vis , int n , int m){
        vis[i][j] = true ;
        int[] drow = {-1 , 0 , 1 , 0};
        int[] dcol = {0 , -1 , 0 , 1};
        for(int k = 0 ; k < 4 ; k++){
            int r = i + drow[k];
            int c = j + dcol[k];
            if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 'O' && vis[r][c] == false){
                dfs(grid, r, c, vis, n, m);
            }
        }
    }
    public void bfs(int[][] grid , int i , int j , boolean[][] vis , int n , int m){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        while(!q.isEmpty()){
            int row = q.peek().row ;
            int col = q.peek().col ;
            q.remove();
            vis[row][col] =true ;
            int[] drow = {-1 , 0 , 1 , 0};
            int[] dcol = {0 , -1 , 0 , 1};
            for(int k = 0 ; k < 4 ; k++){
                int r = row + drow[i];
                int c = col + dcol[i];
                if( r>=0 && c>=0 && r<n && c<m && grid[r][c] == 'O' && vis[r][c] == false){
                    q.add(new pair(r , c));
                }
            }
        }
    }
    class pair{
        int row ;
        int col ;
        public pair(int i , int j){
            this.row = i ;
            this.col = j ;
        }
    }
    
}



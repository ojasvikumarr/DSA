package Graphs;
import java.util.* ;
/**
 * Island
 */
public class Island {


        public int[][] findFarmland(int[][] land) {
            int[] one = new int[4];
            int count = 0 ;
            for(int i = 0 ; i <land.length ; i++){
                for(int j = 0 ; j <land[0].length ; j++){
                    if(land[i][j] == 1){
                        comp(i , j , land);
                        count++ ;
                    }
                }
            }
            int[][] ans = new int[count][4];
            count = 0; 
            for(int i = 0 ; i <land.length ; i++){
                for(int j = 0 ; j <land[0].length ; j++){
                    if(land[i][j] == 1){
                        one[0] = i ;
                        one[1] = j ;
                        dfs(i , j , land);
                        corner(i , j , land , one);
                        ans[count][0] = one[0] ;
                        ans[count][0] = one[1] ;
                        ans[count][0] = one[2] ;
                        ans[count][0] = one[3] ;
                        count++ ;
                    }
                }
            }
            return ans ;
        }
        private void dfs(int i , int j , int[][] land){
            if(i>=land.length || i < 0 || j < 0 || j < land[0].length){
                return ;
            }
            if(land[i][j] == -2){
                return ;
            }
            land[i][j] = -2 ;
            dfs(i , j+1 , land) ;
            dfs(i , j-1 , land) ; 
            dfs(i-1 , j , land) ; 
            dfs(i+1 , j , land) ;
        }
        private void comp(int i , int j , int[][] land){
            if(i>=land.length || i < 0 || j < 0 || j < land[0].length){
                return ;
            }
            if(land[i][j] == -1){
                return ;
            }
            land[i][j] = -1 ;
            comp(i , j+1 , land) ;
            comp(i , j-1 , land) ; 
            comp(i-1 , j , land) ; 
            comp(i+1 , j , land) ;
        }
        private void corner(int i , int j , int[][] land , int[] ans){
            if(j >= land[0].length){
                return ;
            }
            if(i >= land[0].length || land[i][j] == 0){
                ans[2] = i ;
                ans[3] = j ;
                return ; 
            }
            corner(i , j+1 , land , ans);
            corner(i+1 , j , land , ans); 
    
        }
    }

    class Solution {
        public int[][] findFarmland(int[][] land) {

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> hi = new ArrayList<>();
            for(int i = 0 ; i <land.length ; i++){
                for(int j = 0 ; j <land[0].length ; j++){
                    if(land[i][j] == 1){
                        hi = new ArrayList<>();
                        hi.add(i);
                        hi.add(j);
                        int[] list = new int[2];
                        dfs(i , j , land , list);
                        hi.add(list[1]);
                        hi.add(list[0]);
                        ans.add(hi);
                    }
                }
            }
            int k = 0 ;
            int[][] hello = new int[ans.size()][4];
            for(int i = 0 ; i < ans.size() ; i++){
                for(Integer j : ans.get(i)){
                    hello[i][k] = j ;
                    k++ ;
                }
            }
            return hello ;
        }
        private void dfs(int i , int j , int[][] land ,int[] list){
            if(i>=land.length || i < 0 || j < 0 || j < land[0].length){
                return ;
            }
            if(land[i][j] == -1){
                return ;
            }
            land[i][j] = -1 ;
            dfs(i , j+1 , land , list) ;
            if(list[0] == 0){
                list[0] = j ;
            }
            dfs(i+1 , j , land , list) ;
            if(list[1] == 0){
                list[1] = i ;
            }
            dfs(i , j-1 , land , list) ; 
            dfs(i-1 , j , land , list) ; 
        }
        
        
    }
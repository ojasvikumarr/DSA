package Graphs;

import java.util.*;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> rotten = new LinkedList<>();
        int freshcnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshcnt++;
                }
            }
        }
        int min = 0;
        while (!rotten.isEmpty() && freshcnt > 0) {
            min++;
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] curr = rotten.remove();
                int x = curr[0];
                int y = curr[1];
                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (xx < 0 || yy < 0 || xx == row || yy == col) {
                        continue;
                    }
                    if (grid[xx][yy] == 0 || grid[xx][yy] == 2) {
                        continue;
                    }
                    freshcnt--;
                    grid[xx][yy] = 2;
                    rotten.add(new int[] { xx, yy });
                }
            }
        }
        return freshcnt == 0 ? min : -1;
    }

}

package com.slobokot.problems.hard;

/**
 * Brute force
 */
public class UniquePathsIII980 {
    int END = 2;
    int START = 1;
    int EMPTY = 0;
    int OBSTACLE = -1;
    int MARK = -2;
    int[][] moves;
    int emptyCount = 0;

    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        int[] start = null;
        int[] end = null;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == EMPTY)
                    emptyCount++;
                else if (grid[i][j] == START)
                    start = new int[]{i,j};
                else if (grid[i][j] == END)
                    end = new int[]{i,j};
            }
        }

        if (end == null || start == null)
            return 0;

        int res = 0;
        for(int i = 0; i < moves.length; i++)
            res += count(grid, start[0] + moves[i][0], start[1] + moves[i][1], 0);
        return res;
    }

    int count(int[][] grid, int r, int c, int sum) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return 0;
        if (grid[r][c] == END) {
            return sum == emptyCount ? 1 : 0;
        }
        if (grid[r][c] != EMPTY) {
            return 0;
        }
        grid[r][c] = MARK;
        int res = 0;
        for(int i = 0; i < moves.length; i++) {
            res += count(grid, r + moves[i][0], c + moves[i][1], sum + 1);
        }
        grid[r][c] = EMPTY;
        return res;
    }
}

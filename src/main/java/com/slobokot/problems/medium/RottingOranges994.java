package com.slobokot.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {
        List<int[]> q = new ArrayList<>();
        int count = 0;
        int[][] moves = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        int minutes = -1;
        while(!q.isEmpty()) {
            List<int[]> nq = new ArrayList<>();

            for(int[] c : q) {
                for(int[] move : moves) {
                    int ni = c[0]+move[0];
                    int nj = c[1]+move[1];
                    if (0 <= ni && ni < grid.length &&
                            0 <= nj && nj < grid[0].length && grid[ni][nj]==1) {
                        grid[ni][nj] = 2;
                        count--;
                        nq.add(new int[]{ni, nj});
                    }
                }
            }

            if (!nq.isEmpty())
                minutes++;
            q = nq;
        }

        return count == 0 ? minutes : -1;
    }
}

package com.slobokot.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens51 {
    boolean[] rows;
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    int[] queens;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        rows = new boolean[n];
        cols = new boolean[n];
        diag1 = new boolean[2*n - 1];
        diag2 = new boolean[2*n - 1];
        queens = new int[n];
        result = new ArrayList<>();

        solve(0, n);

        return result;
    }

    void solve(int r, int n) {
        if (r == n) {
            addSolution(n);
            return;
        }

        for(int c = 0; c < n; c++) {
            if (!rows[r] && !cols[c] && !diag1[r - c + n - 1] && !diag2[r + c]) {
                queens[r] = c;
                rows[r] = true;
                cols[c] = true;
                diag1[r - c + n - 1] = true;
                diag2[r + c] = true;

                solve(r + 1, n);

                queens[r] = -1;
                rows[r] = false;
                cols[c] = false;
                diag1[r - c + n - 1] = false;
                diag2[r + c] = false;
            }
        }
    }

    void addSolution(int n) {
        List<String> r = new ArrayList<>();
        for(int q : queens) {
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < n; i++)
                s.append(i == q ? 'Q' : '.');
            r.add(s.toString());
        }
        result.add(r);
    }
}

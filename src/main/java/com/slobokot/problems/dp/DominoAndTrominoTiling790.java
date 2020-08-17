package com.slobokot.problems.dp;

import java.util.Arrays;

public class DominoAndTrominoTiling790 {
    static int CLEAR = 0;
    static int HALF = 1;
    static int MODULO = 1000_000_007;
    private long[][] dp;

    public int numTilings(int N) {
        dp = new long[N + 1][2];
        for(long[] r : dp)
            Arrays.fill(r, -1);

        return (int)trim(cachedSolve(N, CLEAR));
    }

    private long solve(int n, int state) {
        if (state == CLEAR) {
            if (n < 0) return 0;
            if (n == 0) return 1;

            long half = trim(2 * cachedSolve(n - 1, HALF));
            long vertical = cachedSolve(n - 1, CLEAR);
            long horizontal = cachedSolve(n - 2, CLEAR);
            return trim(half + vertical + horizontal);
        }

        // state == HALF
        if (n <= 1)
            return 0;

        long completeHalf = cachedSolve(n - 2, CLEAR);
        long continueHalf = cachedSolve(n - 1, HALF);

        return trim(completeHalf + continueHalf);
    }

    private long cachedSolve(int n, int state) {
        if (n < 0)
            return solve(n, state);

        if (dp[n][state] == -1) {
            dp[n][state] = solve(n, state);
        }

        return dp[n][state];
    }

    private long trim(long v) {
        return v < MODULO ? v : v % MODULO;
    }
}

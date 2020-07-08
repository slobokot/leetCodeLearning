package com.slobokot.problems.dp;

public class LongestArithmeticSequence1027 {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length < 2) return A.length;
        int[][] dp = new int[A.length][20001];

        int max = 0;
        for(int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j] + 10000;
                dp[i][diff] = 1 + dp[j][diff];
                max = Math.max(max, dp[i][diff]);
            }
        }

        return max > 0 ? max + 1 : max;
    }
}

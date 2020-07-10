package com.slobokot.problems.easy;

public class ClimbingStairs70 {
    int[] dp = new int[50];

    public int climbStairs(int n) {
        if (n <= 3) return n;
        if (dp[n] == 0)
            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}

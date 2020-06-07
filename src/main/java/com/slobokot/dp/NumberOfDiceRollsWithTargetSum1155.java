package com.slobokot.dp;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum1155 {
    long[][] dp;
    long hit;
    long miss;
    public int numRollsToTarget(int d, int f, int target) {
        dp = new long[d][target];
        for(long[] r : dp)
            Arrays.fill(r, -1);
        return (int)(fn(d, f, target, 1) % (1000_000_007));
    }

    long fn(int d, int f, int target, int fi) {
        if (d == 0) return 0;
        if (d == 1) return (1 <= target && target <= f) ? 1 : 0;
        if (d > target || target > d*f) return 0;

        if (dp[d-1][target-1] < 0) {
            long sum = 0;
            for(int i = fi; i <= f; i++) {
                sum += normalize( fn(d - 1, f, target - i, 1) );
            }

            dp[d-1][target-1] = sum;
            miss++;
        } else {
            hit++;
        }

        return dp[d-1][target-1];
    }

    long normalize(long sum) {
        if (sum > Integer.MAX_VALUE)
            return sum % 1000_000_007;
        return sum;
    }
}

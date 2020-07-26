package com.slobokot.problems.medium;

public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0)
            dp[0][0] = 1;
        for(int i = 1; i < obstacleGrid.length; i++)
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i-1][0];

        for(int i = 1; i < obstacleGrid[0].length; i++)
            if (obstacleGrid[0][i] == 0)
                dp[0][i] = dp[0][i-1];


        for(int i = 1; i < obstacleGrid.length; i++)
            for(int j = 1; j < obstacleGrid[0].length; j++)
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j-1];


        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}

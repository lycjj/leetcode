package com.ly.leetcode;

/**
 * @author ly.
 * @date 2021/2/19
 */
public class Question63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        boolean flag;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    flag = true;
                    for (int k = 0; k < j; k++) {
                        if (obstacleGrid[i][k] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else if(j == 0) {
                    flag = true;
                    for (int k = 0; k < i; k++) {
                        if (obstacleGrid[k][j] == 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{1,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}

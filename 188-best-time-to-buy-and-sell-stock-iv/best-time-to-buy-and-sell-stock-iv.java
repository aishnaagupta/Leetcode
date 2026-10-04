class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
        }
        return buysell(0, 1, k, prices, n, dp);
    }

    int buysell(int i, int buy, int k, int[] prices, int n, int[][][] dp) {
        if (k == 0) {
            return 0;
        }
        if (i == n) {
            return 0;
        }

        if (dp[i][buy][k] != -1) {
            return dp[i][buy][k];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[i] + buysell(i + 1, 0, k, prices, n, dp)),
                    (0 + buysell(i + 1, 1, k, prices, n, dp)));
        } else {
            profit = Math.max((prices[i] + buysell(i + 1, 1, k - 1, prices, n, dp)),
                    (0 + buysell(i + 1, 0, k, prices, n, dp)));
        }

        return dp[i][buy][k] = profit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
        }
        return buysell(0, 1, 2, prices, n, dp);
    }

    int buysell(int i, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (cap == 0) {
            return 0;
        }
        if (i == n) {
            return 0;
        }

        if (dp[i][buy][cap] != -1) {
            return dp[i][buy][cap];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[i] + buysell(i + 1, 0, cap, prices, n, dp)),
                    (0 + buysell(i + 1, 1, cap, prices, n, dp)));
        } else {
            profit = Math.max((prices[i] + buysell(i + 1, 1, cap - 1, prices, n, dp)),
                    (0 + buysell(i + 1, 0, cap, prices, n, dp)));
        }

        return dp[i][buy][cap] = profit;
    }
}

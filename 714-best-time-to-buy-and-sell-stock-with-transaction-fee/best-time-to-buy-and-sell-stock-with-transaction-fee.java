class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return buysell(0, 1, prices, n, dp, fee);
    }

    int buysell(int i, int buy, int[] prices, int n, int[][] dp, int fee) {
        if (i == n) {
            return 0;
        }
        if (dp[i][buy] != -1) {
            return dp[i][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max((-prices[i] + buysell(i + 1, 0, prices, n, dp, fee)),
                    (0 + buysell(i + 1, 1, prices, n, dp, fee)));
        } else {
            profit = Math.max((prices[i] + buysell(i + 1, 1, prices, n, dp, fee) - fee),
                    0 + buysell(i + 1, 0, prices, n, dp, fee));
        }
        return dp[i][buy] = profit;

    }
}
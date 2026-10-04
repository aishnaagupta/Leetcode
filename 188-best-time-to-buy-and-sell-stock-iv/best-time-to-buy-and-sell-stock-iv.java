class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2 * k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return buysell(0, 0, k, prices, n, dp);
    }

    int buysell(int i, int trans, int k, int[] prices, int n, int[][] dp) {
        if (trans == 2 * k || i == n) {
            return 0;
        }

        if (dp[i][trans] != -1) {
            return dp[i][trans];
        }

        if (trans % 2 == 0) {
            return dp[i][trans] = Math.max((-prices[i] + buysell(i + 1, trans + 1, k, prices, n, dp)),
                    (0 + buysell(i + 1, trans, k, prices, n, dp)));
        }

        return dp[i][trans] = Math.max((prices[i] + buysell(i + 1, trans + 1, k, prices, n, dp)),
                (0 + buysell(i + 1, trans, k, prices, n, dp)));
    }
}
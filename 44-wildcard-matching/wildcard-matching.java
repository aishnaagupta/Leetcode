class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m];
        return wild(n - 1, m - 1, s, p, dp);
    }

    boolean wild(int i, int j, String s, String p, Boolean[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 && j >= 0) {
            return false;
        }
        if (i >= 0 && j < 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(j) == p.charAt(i) || p.charAt(i) == '?') {
            return dp[i][j] = wild(i - 1, j - 1, s, p, dp);
        }

        if (p.charAt(i) == '*') {
            return dp[i][j] = wild(i - 1, j, s, p, dp) || wild(i, j - 1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}
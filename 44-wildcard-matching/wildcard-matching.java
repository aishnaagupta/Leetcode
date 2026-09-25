//MEMOIZATION
class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        Boolean[][] dp = new Boolean[n][m]; //B captical Boolean(T/F/NULL) because this is a wrapper class and can contain null values as inital; not boolean(T/F) becoz then inital values would be false;

        return wild(n - 1, m - 1, s, p, dp);
    }

    boolean wild(int i, int j, String s, String p, Boolean[][] dp) {

        // Both strings completely matched
        if (i < 0 && j < 0) {
            return true;
        }

        // Pattern finished but string still has characters
        if (i < 0 && j >= 0) {
            return false;
        }

        // String finished, check whether remaining pattern
        // consists entirely of '*'
        if (j < 0 && i >= 0) {
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

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = wild(i - 1, j - 1, s, p, dp);
        }
        if (p.charAt(i) == '*') {
            return dp[i][j] = wild(i - 1, j, s, p, dp) || wild(i, j - 1, s, p, dp);
        }
        return dp[i][j] = false;
    }
}
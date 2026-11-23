class Solution {
    public boolean checkValidString(String s) {
        //use Boolean (wrapper class) so as to get null values
        Boolean[][] dp = new Boolean[s.length()][s.length() + 1];
        //dp has length+1 columns because for eg count in string of len 4, can be max 4 bcoz what if string is "(((("
        return check(s, 0, 0, dp);
    }

    public static boolean check(String s, int i, int count, Boolean[][] dp) {
        if (count < 0) {
            return false;
        }

        if (i == s.length()) {
            return count == 0;
        }

        if (dp[i][count] != null) {
            return dp[i][count];
        }

        if (s.charAt(i) == '(') {
            return dp[i][count] = check(s, i + 1, count + 1, dp);
        }
        if (s.charAt(i) == ')') {
            return dp[i][count] = check(s, i + 1, count - 1, dp);
        }

        return dp[i][count] = check(s, i + 1, count + 1, dp) || check(s, i + 1, count - 1, dp)
                || check(s, i + 1, count, dp);
    }
}
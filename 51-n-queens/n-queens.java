class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        queens(board, 0, ans);
        return ans;
    }

    public void queens(boolean[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            List<String> curr = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder rowString = new StringBuilder();
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j]) {
                        rowString.append("Q");
                    } else {
                        rowString.append(".");
                    }
                }
                curr.add(rowString.toString());
            }
            ans.add(curr);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1, ans);
                board[row][col] = false;
            }
        }
    }

    boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
}
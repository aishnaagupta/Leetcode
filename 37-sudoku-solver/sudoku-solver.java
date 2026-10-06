class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        int row = -1;
        int col = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    break;
                }
            }

            if (row != -1) {
                break;
            }
        }

        if (row == -1) {
            return true;
        }

        for (char n = '1'; n <= '9'; n++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = n;

                if (solve(board)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }
        return false;
    }

    boolean isSafe(char[][] board, int row, int col, char n) {
        //same row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) {
                return false;
            }
        }

        //same column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n) {
                return false;
            }
        }

        //same row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n) {
                return false;
            }
        }

        int rowStart = row - row % 3;
        int colStart = col - col % 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (board[i][j] == n) {
                    return false;
                }
            }
        }

        return true;
    }
}
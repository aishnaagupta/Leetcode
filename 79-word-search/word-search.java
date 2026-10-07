class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean check(char[][] board, String word, int cur, int r, int c) {
        if (cur == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(cur)) {
            return false;
        }

        char a = board[r][c];
        board[r][c] = '!';

        boolean found = check(board, word, cur + 1, r - 1, c) || check(board, word, cur + 1, r + 1, c)
                || check(board, word, cur + 1, r, c - 1) || check(board, word, cur + 1, r, c + 1);

        board[r][c] = a;
        return found;
    }
}